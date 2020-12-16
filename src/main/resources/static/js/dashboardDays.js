var all = $(".date-field").map(function() {
    var start = moment();
    var end = moment(this.innerHTML, "YYYY-MM-DD");
    var amountofDays = moment().diff(end,'days',false);
    this.innerHTML = amountofDays + " days since added"
}).get();