$("#sortable").sortable();

$('.add-todo').on('keypress', function (e) {
        if(e.which == 13) {
            if($(this).val() !='') {
                var value = $(this).val();
                addTodo(value);

            }
        }
});

function addTodo(value){
    $.post("/todoList/" + value)
        .done(function() {
            var content = '<li class="ui-state-default text-primary"><div class="checkbox"><label><input type="checkbox" value="" /><p>' + value + '</p></label></div></li>';
            $("#sortable").append(content);
            $('.add-todo').val('');
        })
        .fail(function(){
            alert('Error while adding todo');
        })
}

$('.todolist').on('change', '#sortable li input[type="checkbox"]', function () {
    var checkBox = $(this);
    if (checkBox.prop('checked')) {
        var value = checkBox.parent().parent().find('p').text();
        $.ajax({
            url: '/todoList/' + value,
            type: 'PUT',
            async: false,
            success: function (result) {
                checkBox.parent().removeClass("text-primary");
                checkBox.parent().addClass("text-success");
                checkBox.attr("disabled", true);
            },
            error: function (error) {
                checkBox.prop('checked', false);
                alert('Error while updating todo');
            }
        });
    }
});

