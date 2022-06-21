function loadAllItems() {
    $(".itemTableBody").empty();
    $.ajax({
        url: "http://localhost:8080/SpringWithMaven_war/item",
        method: "GET",
        success: function (resp) {
            for (const item of resp.data) {
                let row = `<tr><td>${item.code}</td><td>${item.name}</td><td>${item.qtyOnHand}</td><td>${item.unitPrice}</td></tr>`;
                $(".itemTableBody").append(row);
            }
        }
    });
}

loadAllItems();

$("#btn_AddNewItem").click(function () {
    var itemCode = $("#ItemCode").val();
    var itemName = $("#ItemName").val();
    var itemQty = $("#ItemQuantity").val();
    var itemPrice = $("#ItemPrice").val();

    let item = {
        code: itemCode,
        name: itemName,
        qtyOnHand: itemQty,
        unitPrice: itemPrice
    }

    $.ajax({
        url: "http://localhost:8080/SpringWithMaven_war/item",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(item),
        success: function (res) {
            if (res.code == 200) {
                alert(res.message);
                loadAllItems();
            } else if (res.code == 400) {
                alert(res.message);
            } else {
                alert(res.data);
            }
        }
    });
    $("#btn_AddNewItem").attr("disabled", true);
});

function searchItem() {
    let itemCode = $("#ItemSearch").val();

    $.ajax({
        url: "http://localhost:8080/SpringWithMaven_war/item?id="+itemCode,
        method: "GET",
        success: function (resp) {
            console.log(resp.data.code + " " + resp.data.name + " " + resp.data.qtyOnHand + " " +resp.data.unitPrice);
            $("#searchItemCode").val(resp.data.code);
            $("#searchItemName").val(resp.data.name);
            $("#searchItemQuantity").val(resp.data.qtyOnHand);
            $("#searchItemPrice").val(resp.data.unitPrice);
        }
    });
}

$("#searchButten").click(function () {
    searchItem();
});

$("#deleteItem").click(function () {
    searchItem()
    let itemCode = $("#ItemSearch").val();
    $.ajax({
        url: "http://localhost:8080/SpringWithMaven_war/item?id=" + itemCode,
        method: "DELETE",
        success: function (resp) {
            if (resp.code == 200) {
                alert(resp.message);
                loadAllItems();
            } else if (resp.code == 400) {
                alert(resp.data);
            } else {
                alert(resp.data);
            }
        }
    });
});

$("#update").click(function () {

    searchItem();

    let itemCode = $("#searchItemCode").val();
    let itemName = $("#searchItemName").val();
    let itemQty = $("#searchItemQuantity").val();
    let itemPrice = $("#searchItemPrice").val();

    let updateItem = {
        code: itemCode,
        name: itemName,
        qtyOnHand: itemQty,
        unitPrice: itemPrice
    }

    $.ajax({
        url: "http://localhost:8080/SpringWithMaven_war/item",
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(updateItem),
        success: function (resp) {
            if (resp.code == 200) { // process is  ok
                alert(resp.message);
                loadAllItems();
            } else if (resp.code == 400) { // there is a problem with the client side
                alert(resp.message);
            } else {
                alert(resp.data); // else maybe there is an exception
            }
        }
    });
});

/*=================Text feild focusing and validation==============*/
var itemCodeRegx = /^[I][0]{2}[-][0-9]{3}$/;
var itemNameRegx = /^[A-z]{3,}\s[0-9]{0,}[A-z]{0,}$/;
var itemQtyRegx = /^[0-9]{1,4}$/;
var itemPriceRegx = /^[0-9]{1,}.[0-9]{2}$/;


$("#ItemCode").keydown(function (e) {
    if (e.key == "Enter") {
        var output = $("#ItemCode").val();
        if (itemCodeRegx.test(output)) {
            $("#ItemCode").css('border-color', '#04db14');
            $("#ItemCode").css('box-shadow', '0 0 0 0.25rem rgb(13 110 253 / 25%)');
            $("#ItemCode").css('color', '#04db14');
            $("#lbleItemCode").text("");
            $("#ItemName").focus();
        } else {
            $("#ItemCode").css('border-color', '#ff0202');
            $("#ItemCode").css('box-shadow', '0 0 0 0.25rem rgb(13 110 253 / 25%)');
            $("#ItemCode").css('color', '#ff0202');
            $("#lbleItemCode").text("Item code is a required field : Pattern I00-000");
            $("#ItemCode").focus();
        }
    }
});
$("#ItemName").keydown(function (e) {
    if (e.key == "Enter") {
        var output = $("#ItemName").val();
        if (itemNameRegx.test(output)) {
            $("#ItemName").css('border-color', '#04db14');
            $("#ItemName").css('box-shadow', '0 0 0 0.25rem rgb(13 110 253 / 25%)');
            $("#ItemName").css('color', '#04db14');
            $("#lbleItemName").text("");
            $("#ItemQuantity").focus();
        } else {
            $("#ItemName").css('border-color', '#ff0202');
            $("#ItemName").css('box-shadow', '0 0 0 0.25rem rgb(13 110 253 / 25%)');
            $("#ItemName").css('color', '#ff0202');
            $("#lbleItemName").text("Item name is a required field : Pattern Lux 74g");
            $("#ItemName").focus();
        }
    }
});
$("#ItemQuantity").keydown(function (e) {
    if (e.key == "Enter") {
        var output = $("#ItemQuantity").val();
        if (itemQtyRegx.test(output)) {
            $("#ItemQuantity").css('border-color', '#04db14');
            $("#ItemQuantity").css('box-shadow', '0 0 0 0.25rem rgb(13 110 253 / 25%)');
            $("#ItemQuantity").css('color', '#04db14');
            $("#lbleItemQuantity").text("");
            $("#ItemPrice").focus();
        } else {
            $("#ItemQuantity").css('border-color', '#ff0202');
            $("#ItemQuantity").css('box-shadow', '0 0 0 0.25rem rgb(13 110 253 / 25%)');
            $("#ItemQuantity").css('color', '#ff0202');
            $("#lbleItemQuantity").text("Item quantity should be a number : 140");
            $("#ItemQuantity").focus();
        }
    }
});
$("#ItemPrice").keydown(function (e) {
    if (e.key == "Enter") {
        var output = $("#ItemPrice").val();
        if (itemPriceRegx.test(output)) {
            $("#ItemPrice").css('border-color', '#04db14');
            $("#ItemPrice").css('box-shadow', '0 0 0 0.25rem rgb(13 110 253 / 25%)');
            $("#ItemPrice").css('color', '#04db14');
            $("#lbleItemPrice").text("");
            $("#btn_AddNewItem").attr("disabled", false);
        } else {
            $("#ItemPrice").css('border-color', '#ff0202');
            $("#ItemPrice").css('box-shadow', '0 0 0 0.25rem rgb(13 110 253 / 25%)');
            $("#ItemPrice").css('color', '#ff0202');
            $("#lbleItemPrice").text("Item price should be a number with two decimal places : 100.00");
            $("#ItemPrice").focus();
        }
    }
});