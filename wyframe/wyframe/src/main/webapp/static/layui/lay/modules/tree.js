/** layui-v2.2.6 MIT License By https://www.layui.com */
;
layui.define("jquery",
    function(e) {
        "use strict";
        var o = layui.$,
            a = layui.hint(),
            i = "layui-tree-enter",
            r = function(e) {
                this.options = e
            },
            t = {
                arrow: ["&#xe623;", "&#xe625;"],
                checkbox: ["&#xe626;", "&#xe627;"],
                radio: ["&#xe62b;", "&#xe62a;"],
                branch: ["&#xe622;", "&#xe624;"],
                leaf: "&#xe621;"
            };
        r.prototype.init = function(e) {
            var o = this;
            e.addClass("layui-box layui-tree"),
            o.options.skin && e.addClass("layui-tree-skin-" + o.options.skin),
                o.tree(e),
                o.on(e)
        },
            r.prototype.tree = function(e, a) {
                var i = this,
                    r = i.options,
                    n = a || r.nodes;
                layui.each(n,
                    function(a, n) {
                        var l = n.children && n.children.length > 0,
                            c = o('<ul class="' + (n.spread ? "layui-show": "") + '"></ul>'),
                            s = o(["<li " + (n.spread ? 'data-spread="' + n.spread + '"': "") + ">",
                                function() {
                                    return l ? '<i class="layui-icon layui-tree-spread">' + (n.spread ? t.arrow[1] : t.arrow[0]) + "</i>": ""
                                } (),
                                function() {
                                    return r.check ? '<i class="layui-icon layui-tree-check">' + ("checkbox" === r.check ? t.checkbox[0] : "radio" === r.check ? t.radio[0] : "") + "</i>": ""
                                } (),
                                function() {
                                    return '<a href="' + (n.href || "javascript:;") + '" ' + (r.target && n.href ? 'target="' + r.target + '"': "") + ">" + ('<i class="layui-icon layui-tree-' + (l ? "branch": "leaf") + '">' + (l ? n.spread ? t.branch[1] : t.branch[0] : t.leaf) + "</i>") + ("<cite>" + (n.name || "未命名") + "</cite></a>")
                                } (), "</li>"].join(""));
                        l && (s.append(c), i.tree(c, n.children)),
                            e.append(s),
                        "function" == typeof r.click && i.click(s, n),
                            i.spread(s, n),
                        r.drag && i.drag(s, n)
                    })
            },
            r.prototype.click = function(e, o) {
                var a = this,
                    i = a.options;
                e.children("a").on("click",
                    function(e) {
                        layui.stope(e),
                            i.click(o)
                    })
            },
            r.prototype.spread = function(e, o) {
                var a = this,
                    i = (a.options, e.children(".layui-tree-spread")),
                    r = e.children("ul"),
                    n = e.children("a"),
                    l = function() {
                        e.data("spread") ? (e.data("spread", null), r.removeClass("layui-show"), i.html(t.arrow[0]), n.find(".layui-icon").html(t.branch[0])) : (e.data("spread", !0), r.addClass("layui-show"), i.html(t.arrow[1]), n.find(".layui-icon").html(t.branch[1]))
                    };
                r[0] && (i.on("click", l), n.on("dblclick", l))
            },
            r.prototype.on = function(e) {
                var a = this,
                    r = a.options,
                    t = "layui-tree-drag";
                e.find("i").on("selectstart",
                    function(e) {
                        return ! 1
                    }),
                r.drag && o(document).on("mousemove",
                    function(e) {
                        var i = a.move;
                        if (i.from) {
                            var r = (i.to, o('<div class="layui-box ' + t + '"></div>'));
                            e.preventDefault(),
                            o("." + t)[0] || o("body").append(r);
                            var n = o("." + t)[0] ? o("." + t) : r;
                            n.addClass("layui-show").html(i.from.elem.children("a").html()),
                                n.css({
                                    left: e.pageX + 10,
                                    top: e.pageY + 10
                                })
                        }
                    }).on("mouseup",
                    function() {
                        var e = a.move;
                        e.from && (e.from.elem.children("a").removeClass(i), e.to && e.to.elem.children("a").removeClass(i), a.move = {},
                            o("." + t).remove())
                    })
            },
            r.prototype.move = {},
            r.prototype.drag = function(e, a) {
                var r = this,
                    t = (r.options, e.children("a")),
                    n = function() {
                        var t = o(this),
                            n = r.move;
                        n.from && (n.to = {
                            item: a,
                            elem: e
                        },
                            t.addClass(i))
                    };
                t.on("mousedown",
                    function() {
                        var o = r.move;
                        o.from = {
                            item: a,
                            elem: e
                        }
                    }),
                    t.on("mouseenter", n).on("mousemove", n).on("mouseleave",
                        function() {
                            var e = o(this),
                                a = r.move;
                            a.from && (delete a.to, e.removeClass(i))
                        })
            },
            e("tree",
                function(e) {
                    var i = new r(e = e || {}),
                        t = o(e.elem);
                    return t[0] ? void i.init(t) : a.error("layui.tree 没有找到" + e.elem + "元素")
                })
    });