function initPayPalButton() {
  paypal
    .Buttons({
      // Sets up the transaction when a payment button is clicked
      createOrder: function (_, actions) {
        return actions.order.create({
          intent: "CAPTURE",
          payer: {
            name: {
              given_name: $("#first-name").text(),
              surname: $("#last-name").text(),
            },
            address: {
              address_line_1: $("#address").text(),
            },
            phone: {
              phone_type: "MOBILE",
              phone_number: {
                national_number: $("#phone").text(),
              },
            },
          },
          purchase_units: [
            {
              amount: {
                value: String(
                  parseInt($("#total-amount").text().trim(), 10) / 22_000
                ),
              },
            },
          ],
        });
      },

      // Finalize the transaction after payer approval
      onApprove: function (_, actions) {
        return actions.order.capture().then(function () {
          window.location.href = "../thanks.jsp";
        });
      },
    })
    .render("#paypal-button-container");
}

window.addEventListener("DOMContentLoaded", initPayPalButton);
