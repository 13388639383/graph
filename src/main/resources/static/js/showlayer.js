function showLayer(id) {
    var left = ($(window).width() - $(id).width())/2;
    var top  = ($(window).height() - $(id).height())/2;

    $(id).css({"top": top, "left": left, "display": "block"});
}
function hideLayer(id) {
    $(id).css({"display": "none"});
}
