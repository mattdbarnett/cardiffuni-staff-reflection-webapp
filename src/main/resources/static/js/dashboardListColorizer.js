var listitems = Array.from(document.getElementsByClassName("list-group-item"));
listitems_divided = listitems.filter(function(value, index, Arr) {
    return index % 2 == 0;
});

listitems_divided.forEach(function(listitem) {
    listitem.style.backgroundColor = "#4d90c9";
});