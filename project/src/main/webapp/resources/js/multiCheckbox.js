$(document).ready(function () {
    $("#selectAll").click(function () {
        $('input:checkbox:not(:disabled)').prop('checked', this.checked);
    });
});
