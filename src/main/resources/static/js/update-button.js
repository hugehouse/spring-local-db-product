var main = {
    init : function () {
        var _this = this;
        $('#btn-update').on('click', function () {
            _this.update();
        });
    },
    update : function () {
        var data = {
            title: $('#title').val(),
            price: $('#price').val()
        };

        var id = $("table").data("id");

        $.ajax({
            type: 'PUT',
            url: '/products/' + id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('products updated successfully');
            window.location.href = '/products';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();