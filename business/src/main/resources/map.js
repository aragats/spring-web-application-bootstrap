/**
 * Created by Aragats.Amirkhanyan on 28.04.2015.
 */
function map() {
    if (this.entities === undefined) {
        return
    }
    for
    (var idx = 0; idx < this.entities.hashtags.length; idx++) {
        var key = this.entities.hashtags[idx].text;
        var value = 1;
        emit(key, value);
    }
}