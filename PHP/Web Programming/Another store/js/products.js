var jsvar = 0; 
var end = false;
var start = false;
$("#next").on("click", nextPage);
$("#previous").on("click", previousPage);

// ----------------------------------------------------------------
// function that starts on load of the site
// ----------------------------------------------------------------
$(document).ready(function() {
    $.post(
        "getproduct.php", {
            "page": 0,
            "size": 0
        },
        display_table
    );
    $('#previous').prop('disabled', true);
    start = true;
});

// ----------------------------------------------------------------
// function to get the previous page of the database
// ----------------------------------------------------------------
function previousPage() {

    var size = parseInt($('#size').val());
 
    jsvar--;
    document.getElementById("normal").innerHTML = "JS Variable: " + jsvar;
     $.post(
        "getproduct.php", {// php page we're posting to to get data from
            "page": jsvar, // current page
            "size": size // size of page (number of products we want to display)
        },
        display_table // JS function to display new table
    );
    
    if(end) {
        $('#next').prop('disabled', false);  // Re-enable the next button
    }
    
}

// ----------------------------------------------------------------
// function to get the next page of the database
// ----------------------------------------------------------------

function nextPage() {
    var size = parseInt($('#size').val());
  
    jsvar++;
    document.getElementById("normal").innerHTML = "JS Variable: " + jsvar;
    // alert("We are about to try to post");
    $.post(
        "getproduct.php", { // php page we're posting to to get data from
            "page": jsvar, // current page
            "size": size // size of page (number of products we want to display)
        },
        display_table  // JS function to display new table
    );
    if(start) {
        $('#previous').prop('disabled', false);  // Re-enable the previous button
    }
}

// ----------------------------------------------------------------
// function to display the new data from the database
// ----------------------------------------------------------------


function display_table(data, status) {
    // ------------------ Parse json object -----------------
    var results = JSON.parse(data);
    var size = parseInt($('#size').val());
    // alert("We got into display_table");

    //  ------------------ Was there any errors? ------------------
    if (results.status != "") { // If there is no status code it means there was likely an error
        if (results.status == "No products to show") { // We have no products to display
            $('#tableDisplay').html(results.status);
            end = true;
            $('#next').prop('disabled', true);
        }
        else if (results.status == "Got products") { // We have products to display
            $('#tableDisplay').html(results.table);
            $('#countDB').html(results.currSize);
        }
        if (results.currSize < size) {
            end = true;
            $('#next').prop('disabled', true);
        }
        if (jsvar == 0)
            $('#previous').prop('disabled', true);
        

    }
    else {
        alert("Please input a number for the size");
        jsvar = 0;
    }
}