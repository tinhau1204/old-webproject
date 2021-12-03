function searchProductByName(param) {
  var txtSearch = param.value;
  $.ajax({
    url: "salingProduct",
    type: "GET", //send it through get method
    data: {
      action: "searchByName",
      searchName: txtSearch,
    },
    success: function (data) {
      var row = document.getElementById("search-list");
      row.innerHTML = data;
    },
    error: function (_) {
      //Do Something to handle error
    },
  });
}

