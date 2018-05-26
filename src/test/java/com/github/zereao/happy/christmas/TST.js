function dw(t, e) {
    function o(t) {
        return l ? H - PADDING.top - 20 - (H - PADDING.top - PADDING.buttom - 20) / v * (t - p) : H - PADDING.top - (H - PADDING.top - PADDING.buttom - 20) / v * (t - p)
    }

    function a(t, e) {
        return [PADDING.left + (W - PADDING.left - PADDING.right) / (values.length - 1) * t, o(e)]
    }

    function i() {
        for (var t = [], e = 1, o = w.length; o > e; e++) t.push(w[e], b[e]);
        t = ["M", w[0], b[0], "R"].concat(t);
        var a;
        a = l ? "L" + (W - PADDING.left) + "," + 0 + ",42," + 0 + "z" : "L" + (W - PADDING.left) + "," + (H - PADDING.buttom) + ",42," + (H - PADDING.top) + "z", $.attr({path: t}), D.attr({path: t + a})
    }

    var l = t.xr, n = t.line, s = e.color, c = e.dotColor, d = e.dotDiameter, u = e.dotStrokeColor, h = e.dotStroke,
        f = e.opacity;
    PADDING = e.PADDING, W = e.W, H = e.H, r = Raphael(t.id, W, H), textStyle = e.textStyle, values = e.values, len = values.length;
    var v, m = Math.max.apply({}, values), p = Math.min.apply({}, values);
    v = m === p ? m / 2 : m - p, 0 == v && (v = 1);
    var $, w = ([["M"].concat(a(0, values[0]))], []), b = [], x = (r.set(), r.set()),
        D = ((W - PADDING) / values.length, r.path().attr({stroke: "none", fill: s, opacity: f}));
    $ = n ? r.path().attr({stroke: s, "stroke-width": 2}) : r.path().attr({stroke: s, "stroke-width": 0});
    var C;
    for (N = 0, C = values.length - 1; C > N; N++) {
        var y, k = a(N, values[N]), g = a(N + 1, values[N + 1]);
        w[N] = k[0], b[N] = k[1], (y = function (t, e) {
            var o;
            o = n ? {fill: c, stroke: u, "stroke-width": h} : t ? {
                fill: c,
                stroke: u,
                "stroke-width": h
            } : {
                fill: "RGB(194,194,195)",
                stroke: "RGB(194,194,195)",
                "stroke-width": "1"
            }, x.push(r.circle(e[0], e[1], d).attr(o))
        })(N, k), N == C - 1 && y(N + 1, g)
    }
    if (k = a(C, values[C]), w.push(k[0]), b.push(k[1]), !n) if (l) {
        var S = r.text(w[0], b[0] + 15, values[0] + "°C");
        S.attr({fill: "RGB(194,194,195)", "font-size": "14px", "text-anchor": "center"})
    } else {
        var S = r.text(w[0], b[0] - 15, values[0] + "°C");
        S.attr({fill: "RGB(194,194,195)", "font-size": "16px", "text-anchor": "center"})
    }
    var N;
    for (N = n ? 0 : 1, C = values.length; C > N; N++) if (l) {
        var S = r.text(w[N], b[N] + (e.fontWz || 15), values[N] + "°C");
        S.attr(textStyle)
    } else {
        var S = r.text(w[N], b[N] - (e.fontWz || 15), values[N] + "°C");
        S.attr(textStyle)
    }
    i()
}

function initHouers(t) {
    function e(t) {
        for (var e = [], o = ["无持续风向", "东北风", "东风", "东南风", "南风", "西南风", "西风", "西北风", "北风", "旋转风"], a = ["<3级", "3-4级", "4-5级", "5-6级", "6-7级", "7-8级", "8-9级", "9-10级", "10-11级", "11-12级"], i = 0; i < t.length; i++) {
            var r = t[i], l = {}, n = r.jf.slice(8, 10);
            l.time = n, l.template = r.jb, l.wather = n > 5 && 20 > n ? "d" + r.ja : "n" + r.ja, l.windDY = o[r.jd], l.windJB = a[r.jc], l.itemOne = i % 2 ? "item-one" : "", e.push(l)
        }
        return e
    }

    function o(t, e) {
        var o = "";
        return o += '<li class="details-item ' + e.itemOne + '">' + '<i class="item-icon housr_icons ' + e.wather + '"></i>' + '<div class="curor"></div>' + '<p class="wind-info">' + e.windDY + "</p>" + '<p class="wind-js">' + e.windJB + "</p> " + "</li>"
    }

    function a(t, e) {
        return 0 === t ? '<li class="houer-item active">' + e.time + "时</li>" : '<li class="houer-item">' + e.time + "时</li>"
    }

    if (0 !== t) {
        var i, r = t - 1, l = hour3data[r];
        i = l.length;
        var n = function () {
            try {
                return !0
            } catch (t) {
                return !1
            }
        }();
        if (n) if (1 === r) {
            var s = parseInt(sunup[0].slice(0, 2)), c = parseInt(sunup[0].slice(3, 5)), d = 60 * s + c,
                u = parseInt(sunset[0].slice(0, 2)), h = parseInt(sunset[0].slice(3, 5)), f = 60 * u + h, v = new Date,
                m = v.getHours(), p = v.getMinutes(), w = 60 * m + p;
            d > w ? ($($(".sunup .time")[1]).text(sunup[0]), $($(".sunup .time")[0]).text(sunset[0])) : w >= d && f > w ? ($($(".sunup .time")[1]).text(sunup[0]), $($(".sunup .time")[0]).text(sunset[1])) : ($($(".sunup .time")[1]).text(sunup[1]), $($(".sunup .time")[0]).text(sunset[1]))
        } else $($(".sunup .time")[1]).text(sunup[r]), $($(".sunup .time")[0]).text(sunset[r]);
        for (var b = e(l), x = [], D = [], C = 0; i > C; C++) x.push(o(C, b[C])), D.push(a(C, b[C]));
        $(".details-houers-container").empty().html(x.join("")), $(".houers-container").empty().html(D.join(""));
        var y = l.map(function (t) {
            return t.jb
        });
        if (3 > r) {
            var k = "<li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li>";
            $(".content-shade").empty().html(k).css("width", "1300px"), $(".content-container .scroll-container ").css("width", "1306px");
            var g = {id: "drawTF", xr: "xr", line: "line"}, S = {
                color: "#e99a58",
                dotColor: "#e9914c",
                dotDiameter: 5,
                dotStrokeColor: "#fff",
                dotStroke: "3",
                opacity: 0,
                PADDING: {left: 30, top: 7, right: 30, buttom: 7},
                W: 1300,
                H: 70,
                textStyle: {fill: "#999", "font-size": "16px", "text-anchor": "center"},
                values: y,
                fontWz: 20
            }, N = {
                color: "#e99a58",
                dotColor: "#e9914c",
                dotDiameter: 5,
                dotStrokeColor: "#fff",
                dotStroke: "3",
                opacity: 0,
                PADDING: {left: 30, top: 7, right: 30, buttom: 7},
                W: 650,
                H: 70,
                textStyle: {fill: "#999", "font-size": "16px", "text-anchor": "center"},
                values: y,
                fontWz: 20
            };
            $("#drawTF").empty(), $("#drawTE").empty(), $(".header-container .title").text("逐小时预报"), i > 20 ? (dw(g, S), $(".content-container").niceScroll({
                cursorcolor: "#bcbcbc",
                background: "#dfdfdf",
                autohidemode: !1,
                cursorwidth: "10px",
                cursorborder: "none"
            }), $(".content-container").getNiceScroll().show()) : (dw(g, N), $(".content-container").getNiceScroll().hide())
        } else if ($("#drawTF").empty(), $("#drawTE").empty(), i > 9) {
            var g = {id: "drawTF", xr: "xr", line: "line"}, S = {
                color: "#e99a58",
                dotColor: "#e9914c",
                dotDiameter: 5,
                dotStrokeColor: "#fff",
                dotStroke: "3",
                opacity: 0,
                PADDING: {left: 30, top: 7, right: 30, buttom: 7},
                W: 870,
                H: 80,
                textStyle: {fill: "#999", "font-size": "16px", "text-anchor": "center"},
                values: y,
                fontWz: 20
            };
            dw(g, S);
            var G = "<li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li>";
            $(".content-shade").empty().html(G).css("width", "875px"), $(".content-container .scroll-container").css("width", "880px"), $(".content-container").niceScroll({
                cursorcolor: "#bcbcbc",
                background: "#dfdfdf",
                autohidemode: !1,
                cursorwidth: "10px",
                cursorborder: "none"
            }), $(".content-container").getNiceScroll().show()
        } else {
            $(".content-container").getNiceScroll().hide(), $(".header-container .title").text("逐3小时预报"), $("#ascrail2003-hr").hide();
            var g = {id: "drawTE", xr: "xr", line: "line"}, S = {
                color: "#e99a58",
                dotColor: "#e9914c",
                dotDiameter: 5,
                dotStrokeColor: "#fff",
                dotStroke: "3",
                opacity: 0,
                PADDING: {left: 41, top: 7, right: 41, buttom: 7},
                W: 650,
                H: 80,
                textStyle: {fill: "#999", "font-size": "16px", "text-anchor": "center"},
                values: y,
                fontWz: 20
            };
            $("#drawTF").empty(), $("#drawTE").empty(), dw(g, S)
        }
    }
}

"function" != typeof Array.prototype.map && (Array.prototype.map = function (t, e) {
    var o = [];
    if ("function" == typeof t) for (var a = 0, i = this.length; i > a; a++) o.push(t.call(e, this[a], a, this));
    return o
}), $(".weather_lo_box_pro").niceScroll({
    cursorcolor: "#bcbcbc",
    background: "#dfdfdf",
    autohidemode: !1,
    cursorwidth: "10px",
    cursorborder: "none"
}), initHouers(1);
var drawBaseOb = {id: "drawO", xr: "", line: ""}, drawOobject = {
    color: "rgb(255,255,255)",
    dotColor: "#fff",
    dotDiameter: 3,
    dotStrokeColor: "#fff",
    dotStroke: "0",
    opacity: .5,
    PADDING: {left: 42, top: 5, right: 42, buttom: 5},
    W: 687,
    H: 70,
    textStyle: {fill: "#fff", "font-size": "16px", "text-anchor": "center"},
    values: eventDay
}, drawNoneBlue = {
    color: "rgb(254,240,208)",
    dotColor: "#e7924c",
    dotDiameter: 3,
    dotStrokeColor: "#fff",
    dotStroke: "1",
    opacity: .8,
    PADDING: {left: 42, top: 5, right: 42, buttom: 5},
    W: 687,
    H: 70,
    textStyle: {fill: "#252525", "font-size": "16x", "text-anchor": "center"},
    values: eventDay
}, drawNoneBlueq = {
    color: "rgb(254,240,208)",
    dotColor: "#999",
    dotDiameter: 2,
    dotStrokeColor: "#fff",
    dotStroke: "0",
    opacity: .8,
    PADDING: {left: 42, top: 5, right: 42, buttom: 15},
    W: 687,
    H: 70,
    textStyle: {fill: "#7d7d7d", "font-size": "14px", "text-anchor": "center"},
    values: eventNight
};
dw(drawBaseOb, drawOobject);
var drawBaseObq = {id: "drawT", xr: "xr", line: ""}, drawOobjectq = {
    color: "rgb(255,255,255)",
    dotColor: "#fff",
    dotDiameter: 3,
    dotStrokeColor: "#fff",
    dotStroke: "0",
    opacity: .5,
    PADDING: {left: 42, top: 5, right: 42, buttom: 15},
    W: 687,
    H: 70,
    textStyle: {fill: "#fff", "font-size": "14px", "text-anchor": "center"},
    values: eventNight
};
dw(drawBaseObq, drawOobjectq), $("#sky-on").on("click", function () {
    $("#sky-on").hasClass("off") ? ($("#sky-on").removeClass("off"), $(".jq-switch").animate({left: "22px"}, 500), $(".blue-container").addClass("sky").removeClass("backccc"), $("#drawO").empty(), $("#drawT").empty(), $("#drawBar").hide(), dw(drawBaseOb, drawOobject), dw(drawBaseObq, drawOobjectq), $("#drawBar").css({background: "rgba(255,255,255,0.5)"}).show()) : ($("#sky-on").addClass("off"), $(".jq-switch").animate({left: "0px"}, 500), $(".blue-container").removeClass("sky").addClass("backccc"), $("#drawO").empty(), $("#drawT").empty(), $("#drawBar").hide(), dw(drawBaseOb, drawNoneBlue), dw(drawBaseObq, drawNoneBlueq), $("#drawBar").css({background: "rgba(254,240,208,0.8)"}).show())
}), $(".blue-item").on("click", function (t) {
    t.preventDefault(), t.stopPropagation();
    var e = $(this).index(), o = $(".date-bottom-blue"), a = $(".blue-item"), i = $(".date-item");
    if (0 !== e) {
        i.removeClass("active"), i.eq(e).addClass("active"), o.removeClass("date-bottom-active"), $(o[e]).addClass("date-bottom-active");
        var r = $(".item-active").clone();
        $(".item-active").detach(), a.removeClass("active"), $(a[e]).append(r).addClass("active"), hour3data[e - 1].length > 9 ? ($(".three-container").hide(), $(".content-container").show()) : ($(".content-container").hide(), $(".three-container").show(), $(".nicescroll-rails").hide()), initHouers(e)
    }
}), $(".click_warp_item").on("click", function (t) {
    t.preventDefault(), t.stopPropagation();
    var e = $(this).index(), o = $(".date-bottom-blue"), a = $(".blue-item"), i = $(".date-item");
    if (0 !== e) {
        i.removeClass("active"), i.eq(e).addClass("active"), o.removeClass("date-bottom-active"), $(o[e]).addClass("date-bottom-active");
        var r = $(".item-active").clone();
        $(".item-active").detach(), a.removeClass("active"), $(a[e]).append(r).addClass("active"), hour3data[e - 1].length > 9 ? ($(".three-container").hide(), $(".content-container").show()) : ($(".content-container").hide(), $(".three-container").show(), $(".nicescroll-rails").hide()), initHouers(e)
    }
}), $(".date-item").on("click", function (t) {
    t.preventDefault(), t.stopPropagation();
    var e = $(this).index(), o = $(".date-bottom-blue"), a = $(".blue-item"), i = $(".date-item");
    if (0 !== e) {
        i.removeClass("active"), i.eq(e).addClass("active"), o.removeClass("date-bottom-active"), $(o[e]).addClass("date-bottom-active");
        var r = $(".item-active").clone();
        $(".item-active").detach(), a.removeClass("active"), $(a[e]).append(r).addClass("active"), hour3data[e - 1].length > 9 ? ($(".three-container").hide(), $(".content-container").show()) : ($(".content-container").hide(), $(".three-container").show(), $(".nicescroll-rails").hide()), initHouers(e)
    }
}), $(".content-shade > li").on("hover", function () {
    var t = $(this).index(), e = $(".houer-item");
    e.removeClass("active"), $(e[t]).addClass("active");
    var o = $(".details-item");
    o.removeClass("active"), $(o[t]).addClass("active")
}), $(".three-content-shade > li").on("hover", function () {
    var t = $(this).index(), e = $(".houer-item");
    e.removeClass("active"), $(e[8 + t]).addClass("active");
    var o = $(".details-item");
    o.removeClass("active"), $(o[8 + t]).addClass("active")
}), $(".date-item", ".click_warp_item", ".blue-item").on("hover", function () {
    var t = $(this).index(), e = $(".date-item");
    e.removeClass("hover"), $(e[t]).addClass("hover");
    var o = $(".date-bottom-blue");
    o.removeClass("date-bottom-activea"), $(o[t]).addClass("date-bottom-activea")
}), $(".weather_7d").on("mouseleave", function () {
    var t = $(".date-item");
    t.removeClass("hover");
    var e = $(".date-bottom-blue");
    e.removeClass("date-bottom-activea")
});