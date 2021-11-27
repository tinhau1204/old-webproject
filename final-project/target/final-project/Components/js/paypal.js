function initPayPalButton() {
  paypal
    .Buttons({
      // Sets up the transaction when a payment button is clicked
      createOrder: function (_, actions) {
        return actions.order.create({
          purchase_units: [
            {
              amount: {
                value: $("#total-amount").text(), // Can reference variables or functions. Example: `value: document.getElementById('...').value`
              },
            },
          ],
        });
      },

      // Finalize the transaction after payer approval
      onApprove: function (_, actions) {
        return actions.order.capture().then(function () {
          // Successful capture! For dev/demo purposes:

          window.location.href = "../thanks.jsp";
        });
      },
    })
    .render("#paypal-button-container");
}

window.addEventListener("DOMContentLoaded", initPayPalButton);
