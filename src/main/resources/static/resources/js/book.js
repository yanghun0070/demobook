
$(document).ready(function () {

    //책 키워드 별로 검색
    $("#searchBtn").click(function() {
        searchBooks();
    });

    //키워드로 검색한 책 조회
    function searchBooks() {
        $.ajax({
            url: "/api/search/books",
            type: "get",
            data: {
                keyword: $("#keyword").val()
            },
            contentType: "application/json",
        }).done(function (data) {
            console.log(data)
        }).fail(function (xhr, status, errorThrown) {
            alert("관리자에게 문의하세요.")
        });
    }

});