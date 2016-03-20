package com.example.android.intencje;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class JustJava extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_java2);
    }

    /**
     *
     * @return calculated price
     */

    private int calculatePrice(boolean addWhippedCream, boolean addChocolate){
        int basePrice = 5;
        if(addWhippedCream)basePrice += 1;
        if(addChocolate)basePrice += 2;
        return quantity * basePrice;
    }

    /**
     *
     * @param bill
     * @param hasWhippedCream is wheter or not used want whipped cream
     * @param chocolateAdded is wheter or not user wants whipped cream topping
     * @return text summary
     */

    private String createOrderOrderSummary(int bill, boolean hasWhippedCream, boolean chocolateAdded, String name){
        return getString(R.string.order_summary_name, name) +
                "\n" + getString(R.string.order_summary_whipped_cream, hasWhippedCream) +
                "\n" + getString(R.string.order_summary_chocolate, chocolateAdded) +
                "\n" + getString(R.string.order_summary_quantity, quantity) +
                "\n" + getString(R.string.order_summary_price, NumberFormat.getCurrencyInstance().format(bill)) +
                "\n" + getString(R.string.thank_you);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //Find the user's name
        EditText name = (EditText) findViewById(R.id.name_edit_text);
        String userName = name.getText().toString();

        //Figure out if the user want whipped cream topping.
        CheckBox whippedCream = (CheckBox) findViewById(R.id.checkbox_cream);
        boolean hasWhippedCream = whippedCream.isChecked();

        //Figure out if the user wants chocolate topping
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);
        boolean hasChocolate = chocolate.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessege = createOrderOrderSummary(price, hasWhippedCream, hasChocolate, userName);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "bitrut@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject, userName));
        intent.putExtra(Intent.EXTRA_TEXT, priceMessege);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view){
        if(quantity == 100){
            Toast.makeText(getApplicationContext(),
                    "You cannot have more than 100 coffes", Toast.LENGTH_LONG).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view){
        if(quantity == 1){
            Toast.makeText(getApplicationContext(),
                    "You cannot have less than 1 coffee", Toast.LENGTH_LONG).show();
            return;
        }
        quantity -= 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int cups) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + cups);
    }
    public void back(View view){
        Intent order = new Intent(JustJava.this, MainActivity.class);
        startActivity(order);
    }
}
