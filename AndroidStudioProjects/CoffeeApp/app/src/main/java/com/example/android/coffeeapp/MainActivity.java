package com.example.android.coffeeapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int amountOfCoffee = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * line 33 the 'public' access modifier means it can be used in other activity's
     * 'void' means there is no 'return' value
     * the method passes a View object
     * A View occupies a rectangular area on the screen and is responsible for drawing and event handling
     * line 34 is using the CheckBox object and casting it to (CheckBox). findViewById is a method that
     * Finds a view that was identified by the android:id XML attribute that was processed in onCreate(Bundle).
     * line 35 is calling a checkbox method on the 'whippedCreamCheckBox' java object and this method
     * is called 'isChecked'. the returned value is stored in the 'hasWhippedCream' variable using a 'boolean' data type
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.checkbox_text_view);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.checkbox_text_view2);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        EditText customerName = (EditText) findViewById(R.id.autoCompleteTextView);
        String yourName = customerName.getText().toString();


        /**
         * creating a log enables you to see if in the case the checkbox method is functioning
         * concatenating the string with the hasWhippedCream boolean variable enables you to see
         * the result as a string
         */

        int price = calculatePrice(hasChocolate, hasWhippedCream);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, yourName);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order for " + yourName);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }

    /**
     * Calculates the price of the order.
     * amountOfCoffee is the number of cups of coffee ordered
     */

    /**
     * Create summary of the order.
     *
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate    is whether or not the user wants chocolate topping
     * @param price           of the order
     * @return text summary
     */
    private int calculatePrice(boolean addChocolate, boolean addWhippedCream) {
        int basePrice = 5;
        /**
         * returns the price with chocolate
         */
        if (addChocolate) {
            basePrice = basePrice + 2;
        }
        /**
         * returns the price with whipped cream
         */
        if (addWhippedCream) {
            basePrice = basePrice + 1;

        }
        /**
         * returns the total
         */
        return amountOfCoffee * basePrice;

    }


    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String yourName) {
        String priceMessage = "Name: " + yourName;
        priceMessage += "\n" + getString(R.string.ChocolateSummary) + addChocolate;
        priceMessage += "\n" + getString(R.string.WhippedCream) + addWhippedCream;
        priceMessage += "\n" + getString(R.string.QuantitySummary) + amountOfCoffee;
        priceMessage += "\n" + getString(R.string.Total£) + price;
        priceMessage += "\n" + getString(R.string.thankyou);
        return priceMessage;

    }


    /**
     * This message is called when the CheckBox is Clicked
     */


    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        if (amountOfCoffee == 100) {
            return;
        }
        amountOfCoffee = amountOfCoffee + 1;
        display(amountOfCoffee);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        if (amountOfCoffee == 0) {
            return;
        }
        amountOfCoffee = amountOfCoffee - 1;
        display(amountOfCoffee);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int numberOfCoffee) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffee);
    }


}
