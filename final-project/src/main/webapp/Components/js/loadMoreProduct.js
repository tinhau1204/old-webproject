
// $(window).scroll(function() {
//   if($(window).scrollTop() + window.innerHeight == $(document).height()) 
//   {
//     loadMoreProducts();
//   }
// });



function loadMoreProducts()
{
  var amount = document.getElementsByClassName("tree").length;
    $.ajax({
        url: "salingProduct",
        type: "GET", //send it through get method
        data: { 
          action: 'loadMore',
          exist: amount
        },
        success: function(data) {
          var row = document.getElementById("content");
          row.innerHTML +=data;
        },
        error: function(xhr) {
          //Do Something to handle error
        }
      });
}