var main = {
    init : function () {
        var _this = this;
        $('#btn-update').on('click', function () {
            _this.update();
        });
    },
    update : function () {
        var imgName = thumbnail_upload();

        var data = {
            title: $('#title-value').val().trim(),
            price: $('#price-value').val(),
            category: $('#category-value').val(),
            stock: $('#stock-value').val(),
            thumbnailImage: imgName[0],
            bodyImage: imgName[1],
        };

        // if(this.emptyCheck(data.title, data.price)) {
        //     return;
        // }

        // if(this.lettersCheck(data.title, data.price)) {
        //     return;
        // }

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
            var json = error.responseJSON;
            alert('error : ' + json.message);
        });
    },

    // emptyCheck : function(title, price) {
    //     if(title.length <= 0) {
    //         alert('error : none title');
    //         return true;
    //     }
    //     else if(price.length <= 0) {
    //         alert('error : none price');
    //         return true;
    //     }
    //     return false;
    // },

    // lettersCheck : function(title, price) {
    //     var idRegExpTitle = /^[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9\s]{1,30}$/;
    //     if (!idRegExpTitle.test(title)) {
    //         alert("error : Do not Use Special characters.");
    //         return true;
    //     }

    //     var idRegExpPrice = /^[0-9]{1,10}$/;
    //     if (!idRegExpPrice.test(price)) {
    //         alert("error : The price needs to be between 1 and 10 number long.");
    //         return true;
    //     }
    //     return false;
    // }
};

function thumbnail_upload() {
    var thumbnail_tag = document.querySelector("#thubnail-input");
    var thumbnail_img = thumbnail_tag.files[0];

    var body_img_tag = document.querySelector("#body-image-input");
    var body_img = body_img_tag.files[0];

    var imgName = [];
    imgName[0] = thumbnail_img.name;
    imgName[1] = body_img.name;

    var formData = new FormData();
    formData.append("thumbnail", thumbnail_img);
    formData.append("body_img", body_img);

    fetch('/upload/images', {method: "POST", body: formData});

    return imgName;
}

function preview(input, image) {
    var tag = document.querySelector(input);
    var img = tag.files[0];
    var img_url = URL.createObjectURL(img);
    $(image).attr('src', img_url);
}

main.init();