function initPayPalButton() {
  paypal
    .Buttons({
      // Sets up the transaction when a payment button is clicked
      createOrder: function (_, actions) {
        return actions.order.create({
          purchase_units: [
            {
              amount: {
                currency_code: "USD",
                value: String(parseInt($("#total-amount").text(), 10)),
              },
            },
          ],
        });
      },
      onCancel: function (_) {
        window.location.href = "../../Cart.jsp";
      },
      // Finalize the transaction after payer approval
      onApprove: function (_, actions) {
        return actions.order.capture().then(function () {
          window.location.href = "../../thanks.jsp";
        });
      },
    })
    .render("#paypal-button-container");
}

window.addEventListener("DOMContentLoaded", initPayPalButton);
