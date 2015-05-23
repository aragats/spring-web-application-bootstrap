/**
 * Js with methods.
 * Created by Aragats.Amirkhanyan on 29.01.2015.
 */
var REST_API = "api/";
var loading = false;
function sampleMethod() {
    if (loading) {
        return
    }
    loading = true;

    $.ajax({
        url: REST_API + "sample/sampleMethod?lp=" + 1 + "&sp=stringParam" + "&bp=" + true
    }).then(function (data) {

        console.log("Result.size = " + data.size);
        loading = false;
    });
}


