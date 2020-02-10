/**
 * Utils: a javascript libs for prototype extension, fix browser compatibility and utils.
 * 2013, Collin Chan
 *
 * Released into the public domain.
 *
 *THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * @author olar.tan@gmail.com
 * @version 1.0.0
 *
 * @requires
 * null
 */

Number.prototype.toThousands = function () {
    var num = this;
    num = (num || 0).toString(), result = '';
    while (num.length > 3) {
        result = ',' + num.slice(-3) + result;
        num = num.slice(0, num.length - 3);
    }
    if (num) { result = num + result; }
    return result;
};

/*Prototyp extension*/
Date.prototype.addDays = function (num) {
    var value = this.valueOf();
    value += 86400000 * num;
    return new Date(value);
}

Date.prototype.addSeconds = function (num) {
    var value = this.valueOf();
    value += 1000 * num;
    return new Date(value);
}

Date.prototype.addMinutes = function (num) {
    var value = this.valueOf();
    value += 60000 * num;
    return new Date(value);
}

Date.prototype.addHours = function (num) {
    var value = this.valueOf();
    value += 3600000 * num;
    return new Date(value);
}

Date.prototype.addMonths = function (num) {
    var value = new Date(this.valueOf());

    var mo = this.getMonth();
    var yr = this.getYear();

    mo = (mo + num) % 12;
    if (0 > mo) {
        yr += (this.getMonth() + num - mo - 12) / 12;
        mo += 12;
    }
    else
        yr += ((this.getMonth() + num - mo) / 12);

    value.setMonth(mo);
    value.setYear(yr);
    return value;
}

Date.prototype.format = function (mask) {
    var d = this;

    var zeroize = function (value, length) {
        if (!length) length = 2;

        value = String(value);

        for (var i = 0, zeros = ''; i < (length - value.length) ; i++) {
            zeros += '0';
        }

        return zeros + value;
    };

    return mask.replace(/"[^"]*"|'[^']*'|\b(?:d{1,4}|m{1,4}|yy(?:yy)?|([hHMstT])\1?|[lLZ])\b/g, function ($0) {
        switch ($0) {
            case 'd': return d.getDate();
            case 'dd': return zeroize(d.getDate());
            case 'ddd': return ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'][d.getDay()];
            case 'dddd': return ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][d.getDay()];
            case 'M': return d.getMonth() + 1;
            case 'MM': return zeroize(d.getMonth() + 1);
            case 'MMM': return ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'][d.getMonth()];
            case 'MMMM': return ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'][d.getMonth()];
            case 'yy': return String(d.getFullYear()).substr(2);
            case 'yyyy': return d.getFullYear();
            case 'h': return d.getHours() % 12 || 12;
            case 'hh': return zeroize(d.getHours() % 12 || 12);
            case 'H': return d.getHours();
            case 'HH': return zeroize(d.getHours());
            case 'm': return d.getMinutes();
            case 'mm': return zeroize(d.getMinutes());
            case 's': return d.getSeconds();
            case 'ss': return zeroize(d.getSeconds());
            case 'l': return zeroize(d.getMilliseconds(), 3);
            case 'L': var m = d.getMilliseconds();
                if (m > 99) m = Math.round(m / 10);
                return zeroize(m);
            case 'tt': return d.getHours() < 12 ? 'am' : 'pm';
            case 'TT': return d.getHours() < 12 ? 'AM' : 'PM';
            case 'Z': return d.toUTCString().match(/[A-Z]+$/);
                // Return quoted strings with the surrounding quotes removed
            default: return $0.substr(1, $0.length - 2);
        }
    });
};

String.prototype.toDate = function () {
    var time = this;
    if (time != null) {
        var date = new Date(parseInt(time.replace('/Date(', '').replace(')/', ''), 10));
        var month = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
        return date.getFullYear() + '-'+ month + '-'+ currentDate;
    }
    return '';
}

/*String format*/
String.prototype.format = function (args) {
    var result = this;
    if (arguments.length > 0) {
        if (arguments.length == 1 && typeof (args) == "object") {
            for (var key in args) {
                if (args[key] != undefined) {
                    var reg = new RegExp("({" + key + "})", "g");
                    result = result.replace(reg, args[key] == null ? 0 : args[key]);
                }
            }
        }
        else {
            for (var i = 0; i < arguments.length; i++) {
                if (arguments[i] != undefined) {
                    var reg = new RegExp("({[" + i + "]})", "g");
                    result = result.replace(reg, arguments[i]);
                }
            }
        }
    }
    return result;
};
/*  对对象进行深度分析
    缺点：采用字符串替代方式，会造成在不同子对象拥有相同属性时以最后一次出现的对应值为准
*/
String.prototype.render = function (args) {
    var result = this,
        replace = function (originalStr, newStr) {
            var reg = new RegExp("({" + originalStr + "})", "g");
            result = result.replace(reg, newStr);
        },
        analysis = function (paras) {
            if (typeof (paras) == "object") {
                for (var key in paras) {
                    var item = paras[key];
                    if (typeof (item) == "object") {
                        analysis(item);
                    }
                    else {
                        replace(key, item == null ? 0 : item);
                    }
                }
            }
            else {
                replace(paras, paras);
            }
        };
    analysis(args);
    return result;
};

/*Html encode*/
String.prototype.encodeHtml = function () {
    var str = this;
    var s = "";
    if (str.length == 0) return "";
    s = str.replace(/&/g, "&gt;");
    s = s.replace(/</g, "&lt;");
    s = s.replace(/>/g, "&gt;");
    s = s.replace(/ /g, "&nbsp;");
    s = s.replace(/\'/g, "&#39;");
    s = s.replace(/\"/g, "&quot;");
    s = s.replace(/\n/g, "<br>");
    return s;
};

/*Html decode*/
String.prototype.decodeHtml = function () {
    var str = this;
    var s = "";
    if (str.length == 0) return "";
    s = str.replace(/&gt;/g, "&");
    s = s.replace(/&lt;/g, "<");
    s = s.replace(/&gt;/g, ">");
    s = s.replace(/&nbsp;/g, " ");
    s = s.replace(/&#39;/g, "\'");
    s = s.replace(/&quot;/g, "\"");
    s = s.replace(/<br>/g, "\n");
    return s;
};

/*Get value from queryString*/
String.prototype.getValueByKey = function (k) {
    var p = new RegExp('\\b' + k + '\\b', 'gi');
    return this.search(p) != -1 ? decodeURIComponent(this.substr(this.search(p) + k.length + 1).substr(0, this.substr(this.search(p) + k.length + 1).search(/(&|;|$)/))) : "";
};

$.popDialog = function (options) {
    var temp = new newDialog();
    temp.init(options);
    return temp;
};

/*pagination*/

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

var newDialog = function () {
    this.dialog = null;

    this._options = {
        dialogId: null,
        targetId: null,
        title: "标题",
        buttons: null
    };

    var htmlHelper = new Object();

    htmlHelper._getDialogContainerHtml = function (id) {
        var html = [];
        html.push('<div class="modal fade" id="' + id + '">');
        html.push('</div>');
        return html.join('');
    };

    htmlHelper._getDialogTitleHtml = function () {
        var html = [];
        html.push('<div class="modal-header">');
        html.push(' <button type="button" class="close" data-dismiss="modal">×</button>');
        html.push(' <h3></h3>');
        html.push('</div>');
        return html.join('');
    };

    htmlHelper._getDialogBodyHtml = function () {
        var html = [];
        html.push('<div class="modal-body">');
        html.push('</div>');
        return html.join('');
    };

    htmlHelper._getDialogFooterHtml = function (buttons) {
        var html = [];
        html.push('<div class="modal-footer">');
        if (buttons != null) {
            for (var i = 0; i < buttons.length; i++) {
                var btn = buttons[i];
                html.push('<a href="#" class="btn" id=' + btn.id + ' data-dismiss="modal">' + btn.title + '</a>');
            }
        }
        html.push('</div>');
        return html.join('');
    };

    this._initDialog = function () {
        if (typeof this._options.dialogId == "undefined") {
            bootbox.alert("请在初始化对象中指定dialogId");
            return;
        }

        if (typeof this._dialog == "undefined") {
            var container = $(htmlHelper._getDialogContainerHtml(this._options.dialogId));
            $(htmlHelper._getDialogTitleHtml()).appendTo(container);
            $(htmlHelper._getDialogBodyHtml()).appendTo(container);

            if (this._options.buttons != null) {
                $(htmlHelper._getDialogFooterHtml(this._options.buttons)).appendTo(container);
            }
            // todo add to body
            $(container).appendTo("body");
            this._dialog = $("#" + this._options.dialogId);
            if (this._options.buttons != null) {
                for (var i = 0; i < this._options.buttons.length; i++) {
                    var btn = this._options.buttons[i];
                    if (typeof btn.click != "undefined") {
                        $(this._dialog.find("#" + btn.id)).unbind('click').on('click', btn.click);
                    }
                }
            }
        }
    };

    this.init = function (options) {
        $.extend(true, this._options, options);
        this._initDialog();
        var dialogTitle = this._dialog.find(".modal-header h3"),
            dialogBody = this._dialog.find(".modal-body");
        dialogTitle.html(this._options.title);
        //dialogBody.html(this._options.body);
        if (dialogBody.html().length == 0) {
            $("#" + this._options.targetId).removeClass("hide").appendTo($(dialogBody));
            //$(dialogBody).find('.lazyCleditor').cleditor();
        }
    };

    this.show = function () {
        this._dialog.modal('show');
    };
};

/* message declare start */
$._messengerDefaults = {
    extraClasses: 'messenger-fixed messenger-theme-air messenger-on-top'
}

/* Bootstrap message wrapper */
var bsMessage= {
    confirm: function (message,confirmFun) {
        var confirm = $.globalMessenger().post({
            message: message,
            hideAfter: 10,
            actions: {
                retry: {
                    label: '确定',
                    /*phrase: 'Retrying TIME',
                    auto: true,
                    delay: 10,*/
                    action: confirmFun
                },
                cancel: {
                    label: '取消',
                    action: function () {
                        return confirm.cancel();
                    }
                }
            }
        });
        return confirm;
    },
    error: function (message) {
        $.globalMessenger().post({
            message: message,
            type: 'error',
            showCloseButton: true
        });
    },
    success: function (message) {
        $.globalMessenger().post({
            message: message,
            type: 'success',
            showCloseButton: true
        });
    }
};
/* message declare end */

function changeDateFormat(cellval) {
    if (cellval == null) {
        return;
    }
    var date = new Date(parseInt(cellval.replace("/Date(", "").replace(")/", ""), 10));
    var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
    var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
    return date.getFullYear() + "-" + month + "-" + currentDate;
};

function dynamicTable() {
    this._options = {
        tableId: null,
        templateId: null,
        initTemplateOnlyOnce: true,//是否只初始化一次模板，如果为true只会初始化一次，false会在每次add新行的时候再次初始化最新模板信息
        allowDeleteLastRow: true,
        addRowCustomEvent: null //默认会传递template, container,instance作为参数 会中断原有事件执行启用自定义事件
    };

    this._template = null; // jsreander template object
    this._table = null; // target container object

    this.init = function (options) {
        this._initOptions(options);
        if (this._options.templateId != undefined
            && this._options.tableId != undefined) {
            //Render Data
            var template = $(this._options.templateId);
            if (template.length == 0) {
                return;
            }
            this._template = template.render();
            this._table = $(this._options.tableId);

            this._initAddRowEvent();
            this._initRemoveRowEvent();
        }
    };

    /* 初始化Options
    */
    this._initOptions = function (options) {
        if (options != null || options != undefined) {
            this._options.tableId = "#" + options.tableId;
            this._options.templateId = "#" + options.templateId;
            this._options.addRowCustomEvent = options.addRowCustomEvent;
            this._options.allowDeleteLastRow = options.allowDeleteLastRow;
            this._options.initTemplateOnlyOnce = options.initTemplateOnlyOnce;
        }
    };

    this._getInstance = function () {
        return new dynamicTable();
    };

    /* 初始化addRow
    */
    this._initAddRowEvent = function () {
        this._table.find("thead tr .addRow").on("click", $.proxy(this._addRowHandler, this));
    };

    this._addRowHandler = function () {
        if (this._options.initTemplateOnlyOnce == false) {
            this._template = $($(this._options.templateId).html()).clone();
            // $(this._options.templateId).render(); by wgj 使用render()事件 貌似不会获取到变更后的最新模板信息
        }
        var newRow = $(this._template).clone();
        var container = $(this._table.find("tbody"));
        if (this._options.addRowCustomEvent != null) {
            this._options.addRowCustomEvent(newRow, container, this);
        }
        else {
            this._removeRowHandler(newRow);
            //Insert into table
            $(newRow).appendTo(container);
        }
    };

    /* 初始化移除事件
    */
    this._initRemoveRowEvent = function () {
        var rows = $(this._options.tableId).find("tbody tr");
        if (rows !== undefined) {
            for (var i = 0; i < rows.length; i++) {
                if (this._options.allowDeleteLastRow == false && i == 0) {
                    continue;
                }
                this._removeRowHandler(rows[i]);
            }
        }
    };

    /* 对当前row中相关操作对象绑定事件事件
    */
    this._removeRowHandler = function (row) {
        var curRow = $(row);
        var items = curRow.find(".removeRow");
        if (items.length > 0) {
            for (var i = 0; i < items.length; i++) {
                $(items[i]).click(this._removeRow(curRow));
            }
        }
    };

    /* 移除当前Row
    */
    this._removeRow = function (row) {
        return function () {
            $(row).remove();
        };
    };
};

$.DynamicTable = function (options) {
    var table = new dynamicTable();
    table.init(options);
};

/* 表单数据校验  支持校验的格式 <input type="text" class="autoInput" data-empty="No" data-validation="标题不能为空！" name="title" />
   必须有data-empty、data-validation属性
   data-empty:Yes/No  No 不允许为空  Yes 允许为空（data-validation 可以不写）
   data-validation:不允许为空时对应的提示文字
*/
var frameTips = '';
var formValidator = function () {
    this._status = true;

    this.init = function () {
        var inputs = $(":input");//获取所有的input标签对象
        var validArray = [];//初始化空数组，用来存放checkbox对象。
        for (var i = 0; i < inputs.length; i++) {
            var obj = $(inputs[i]);
            if (obj.attr("data-empty") != undefined) {
                if (obj.attr("data-empty").toLocaleUpperCase() == 'No'.toLocaleUpperCase()) {
                    validArray.push(obj);
                }
            }
        }
        if (validArray.length > 0) {
            this._validator(validArray);
        }
        return this._status;
    };

    this._validator = function (objs) {
        var targetArray = objs;
        var alerts = [];
        var focusObj = null;
        for (var i = 0; i < targetArray.length; i++) {
            var target = $(targetArray[i]);
            if (target.val().length == 0) {
                alerts.push(target.attr("data-validation"));
                if (focusObj == null) {
                    focusObj = target;
                }
            }
        }
        this._status = false;
        this._show(alerts.join("\r"));
        if (focusObj != null) {
            focusObj.focus()
        }
    };

    this._show = function (tips) {
        frameTips += tips;
        if (frameTips.length > 0) {
            alert(frameTips);
            frameTips = "";
        }
        else {
            this._status = true;
        }
    };
};

/*Compatibility*/
/*String trim*/
if (!String.prototype.trim) {
    String.prototype.trim = function () {
        return this.replace(/^\s+|\s+$/g, '');
    };
}

/*Arrary indexOf*/
if (!Array.prototype.indexOf) {
    Array.prototype.indexOf = function (searchElement /*, fromIndex */) {
        'use strict';
        if (this == null) {
            throw new TypeError();
        }
        var n, k, t = Object(this),
            len = t.length >>> 0;

        if (len === 0) {
            return -1;
        }
        n = 0;
        if (arguments.length > 1) {
            n = Number(arguments[1]);
            if (n != n) { // shortcut for verifying if it's NaN
                n = 0;
            } else if (n != 0 && n != Infinity && n != -Infinity) {
                n = (n > 0 || -1) * Math.floor(Math.abs(n));
            }
        }
        if (n >= len) {
            return -1;
        }
        for (k = n >= 0 ? n : Math.max(len - Math.abs(n), 0) ; k < len; k++) {
            if (k in t && t[k] === searchElement) {
                return k;
            }
        }
        return -1;
    };
}

// Production steps of ECMA-262, Edition 5, 15.4.4.19
// Reference: http://es5.github.com/#x15.4.4.19
if (!Array.prototype.map) {
    Array.prototype.map = function (callback, thisArg) {
        var T, A, k;

        if (this == null) {
            throw new TypeError(" this is null or not defined");
        }

        // 1. Let O be the result of calling ToObject passing the |this| value as the argument.
        var O = Object(this);

        // 2. Let lenValue be the result of calling the Get internal method of O with the argument "length".
        // 3. Let len be ToUint32(lenValue).
        var len = O.length >>> 0;

        // 4. If IsCallable(callback) is false, throw a TypeError exception.
        // See: http://es5.github.com/#x9.11
        if (typeof callback !== "function") {
            throw new TypeError(callback + " is not a function");
        }

        // 5. If thisArg was supplied, let T be thisArg; else let T be undefined.
        if (thisArg) {
            T = thisArg;
        }

        // 6. Let A be a new array created as if by the expression new Array(len) where Array is
        // the standard built-in constructor with that name and len is the value of len.
        A = new Array(len);

        // 7. Let k be 0
        k = 0;

        // 8. Repeat, while k < len
        while (k < len) {
            var kValue, mappedValue;

            // a. Let Pk be ToString(k).
            //   This is implicit for LHS operands of the in operator
            // b. Let kPresent be the result of calling the HasProperty internal method of O with argument Pk.
            //   This step can be combined with c
            // c. If kPresent is true, then
            if (k in O) {
                // i. Let kValue be the result of calling the Get internal method of O with argument Pk.
                kValue = O[k];

                // ii. Let mappedValue be the result of calling the Call internal method of callback
                // with T as the this value and argument list containing kValue, k, and O.
                mappedValue = callback.call(T, kValue, k, O);

                // iii. Call the DefineOwnProperty internal method of A with arguments
                // Pk, Property Descriptor {Value: mappedValue, : true, Enumerable: true, Configurable: true},
                // and false.

                // In browsers that support Object.defineProperty, use the following:
                // Object.defineProperty(A, Pk, { value: mappedValue, writable: true, enumerable: true, configurable: true });

                // For best browser support, use the following:
                A[k] = mappedValue;
            }
            // d. Increase k by 1.
            k++;
        }

        // 9. return A
        return A;
    };
}

function getDocHeight() {
    var doc = document;
    return Math.max(
        Math.max(doc.body.scrollHeight, doc.documentElement.scrollHeight),
        Math.max(doc.body.offsetHeight, doc.documentElement.offsetHeight),
        Math.max(doc.body.clientHeight, doc.documentElement.clientHeight)
    );
}

/* 通用提示描述 */
var generalTips = {
    /* 消息类 */
    message: {
        success: "成功！",
        systemError: "获取数据失败，请重试！" /* 本质为系统异常 */
    }

    /*  */
};

/* hashtable
*/
function hashTable()
{
    var size = 0;
    var entry = new Object();

    this.add = function (key , value)
    {
        if(!this.containsKey(key))
        {
            size ++ ;
        }
        entry[key] = value;
    }

    this.getValue = function (key)
    {
        return this.containsKey(key) ? entry[key] : null;
    }

    this.remove = function ( key )
    {
        if( this.containsKey(key) && ( delete entry[key] ) )
        {
            size --;
        }
    }

    this.containsKey = function ( key )
    {
        return (key in entry);
    }

    this.containsValue = function ( value )
    {
        for(var prop in entry)
        {
            if(entry[prop] == value)
            {
                return true;
            }
        }
        return false;
    }

    this.getValues = function ()
    {
        var values = new Array();
        for(var prop in entry)
        {
            values.push(entry[prop]);
        }
        return values;
    }

    this.getKeys = function ()
    {
        var keys = new Array();
        for(var prop in entry)
        {
            keys.push(prop);
        }
        return keys;
    }

    this.getSize = function ()
    {
        return size;
    }

    this.clear = function ()
    {
        size = 0;
        entry = new Object();
    }
}