/**
 * Example for setting listeners. But this elements does not exist in the example index.html file.
 * Created by Aragats.Amirkhanyan on 24.04.2015.
 */

$("#search").click().click(function () {
    sampleMethod();
});

$("#query").keyup(function () {
    sampleMethod();
});


$("#hashtag").keyup(function () {
    sampleMethod();
});

$("#popular_tags").on("click", "a", function (event) {
    $("#hashtag").val($(this).html());
    sampleMethod();
    return false;
});