var all = $(".date-field").map(function() {
    var start = moment();
    var end = moment(this.innerHTML, "YYYY-DD-MM");
    var amountofDays = moment().diff(end,'days',false);
    this.innerHTML = amountofDays + " days since participation"
}).get();
