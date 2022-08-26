$("#btnsearchOrder").click(function () {
    var OrderID = $("#searchOrder").val();

    $.ajax({
        url:"http://localhost:8080/SpringWithMaven_war/orders?oid="+OrderID,
        method:"GET",
        success:function (resp) {
            var customerID = resp.data.customer.id;
            $("#manageOrderCustomerId").val(customerID);

            $(".manageOrderTableBody").empty();
            let orderDetails = new Array();
            orderDetails=resp.data.orderDetails;
            for (let details of orderDetails) {
                var tableRow = `<tr><td>${details.itemCode}</td><td>${details.qty}</td><td>${details.totalPrice}</td></tr>`;
                $(".manageOrderTable").append(tableRow);
            }

            $(".manageOrderTableBody>tr").click(function (){
               let itemCode = $(this).children().eq(0).text();
               let itemqty = $(this).children().eq(1).text();

               $("#manageOrderItemCode").val(itemCode);
               $("#manageOrderQty").val(itemqty);

            });

        }

    });
});

$("#deleteOrder").click(function () {
    var OrderID = $("#searchOrder").val();
    $.ajax({
        url:"http://localhost:8080/SpringWithMaven_war/orders?oid="+OrderID,
        method:"DELETE",
        success:function (resp) {
            if (resp.code == 200) {
                alert(resp.message);
            }
        }
    });
});
