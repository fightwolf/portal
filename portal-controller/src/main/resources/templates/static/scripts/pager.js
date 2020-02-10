var pagination = {
    init: function (id) {
        var self = this;
        this.id = id;
        this.container = null;
        this.index = 1; // 当前页码, 从1开始
        this.size = 10; // 每页显示记录数
        this.maxButtons = 5; // 显示的分页按钮数量
        this.itemCount = 0; // 记录总数
        this.pageCount = 0; // 总页数
        /**
        * index: 被点击的页码.
        */
        this.onclick = function (index) {
        };
        /**
        * 内部方法.
        */
        this._onclick = function (index) {
            self.index = index;
            self.onclick(index);
            self.render();
        };
        /**
        * 在显示之前计算各种页码变量的值.
        */
        this.calculate = function () {
            self.pageCount = parseInt(Math.ceil(self.itemCount / self.size));
            self.index = parseInt(self.index);
            if (self.index > self.pageCount) {
                self.index = self.pageCount;
            }
        };
        /**
        * 渲染分页控件.
        */
        this.render = function () {
            if (self.id != undefined) {
                var div = document.getElementById(self.id);
                div.view = self;
                self.container = div;
            }
            self.calculate();
            var start, end;
            start = Math.max(1, self.index - parseInt(self.maxButtons / 2));
            end = Math.min(self.pageCount, start + self.maxButtons - 1);
            start = Math.max(1, end - self.maxButtons + 1);
            var str = "<div class=\"pagination\">\n<ul>";
            if (self.pageCount > 1) {
                if (self.index != 1) {
                    str += '<li class="prev"><a href="javascript://1">|<</a></li>';
                    str += '<li class="prev"><a  href="javascript://' + (self.index - 1) + '"><</a></li>';
                } else {
                    str += '<li class="prev disabled"><a>|<</a></li>';
                    str += '<li class="prev disabled"><a><</a></li>';
                }
            }
            for (var i = start; i <= end; i++) {
                if (i == this.index) {
                    str += '<li class="active"><a>' + i + "</a></li>";
                } else {
                    str += '<li><a href="javascript://' + i + '">' + i + "</a></li>";
                }
            }
            if (self.pageCount > 1) {
                if (self.index != self.pageCount) {
                    str += '<li class="next"><a href="javascript://' + (self.index + 1) + '">></a></li>';
                    str += '<li class="next"><a  href="javascript://' + self.pageCount + '">>|</a></li>';
                } else {
                    str += '<li class="next disabled"><a>></a></li>';
                    str += '<li class="next disabled"><a>>|</a></li>';
                }
            }
            //   str += '<li> 共' + self.pageCount + '页</li>';
            str += '<li class="jump-num"> 共' + self.pageCount + '页</li><li class="jump-num">&nbsp;&nbsp;&nbsp;转到第<input class="page-num" type="text" style="width:30px;">页<li>';
            str += '</ul></div><!-- /.init -->\n';
            self.container.innerHTML = str;
            var a_list = self.container.getElementsByTagName('a');
            for (var i = 0; i < a_list.length; i++) {
                a_list[i].onclick = function () {
                    var index = this.getAttribute('href');
                    if (index != undefined && index != '') {
                        index = parseInt(index.replace('javascript://', ''));
                        self._onclick(index)
                    }
                    return false;
                };
            }
            $(".page-num").keyup(function (event) {
                if (event.keyCode == 13) {
                    if ($(".page-num").val().length < 1) {
                        return;
                    }
                    var pageindex = parseInt($(".page-num").val());
                    if (pageindex < 1)
                        pageindex = 1;
                    if (pageindex > self.pageCount) {
                        self._onclick(self.pageCount);
                    }
                    self._onclick(pageindex);
                }
            });
        };
    }
}

/// 分页控件的属性设置
function PagerAttribute(pageIndex, pageCount, pageSize, count) {
    if (this instanceof PagerAttribute) {
        this.pageIndex = pageIndex;
        this.pageCount = pageCount;
        this.pageSize = pageSize;
        this.count = count;
    }
    else {
        return new PagerAttribute(pageIndex, pageCount, pageSize, count);
    }
}