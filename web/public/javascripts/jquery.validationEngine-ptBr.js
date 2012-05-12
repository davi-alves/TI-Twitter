(function ($) {
    $.fn.validationEngineLanguage = function () {
    };
    $.validationEngineLanguage = {
        newLang:function () {
            $.validationEngineLanguage.allRules = {
                "required":{ // Add your regex rules here, you can take telephone as an example
                    "regex":"none",
                    "alertText":"* Campo obrigatório",
                    "alertTextCheckboxMultiple":"* Porfavor selecione uma opção",
                    "alertTextCheckboxe":"* Checkbox obrigatório",
                    "alertTextDateRange":"* Both date range fields are required"
                },
                "dateRange":{
                    "regex":"none",
                    "alertText":"* Inválido ",
                    "alertText2":"Date Range"
                },
                "dateTimeRange":{
                    "regex":"none",
                    "alertText":"* Inválido ",
                    "alertText2":"Date Time Range"
                },
                "minSize":{
                    "regex":"none",
                    "alertText":"* Minimo ",
                    "alertText2":" caracteres permitidos"
                },
                "maxSize":{
                    "regex":"none",
                    "alertText":"* Máximo ",
                    "alertText2":" caracteres permitidos"
                },
                "groupRequired":{
                    "regex":"none",
                    "alertText":"* You must fill one of the following fields"
                },
                "min":{
                    "regex":"none",
                    "alertText":"* Minimum value is "
                },
                "max":{
                    "regex":"none",
                    "alertText":"* Máximo value is "
                },
                "past":{
                    "regex":"none",
                    "alertText":"* Date prior to "
                },
                "future":{
                    "regex":"none",
                    "alertText":"* Date past "
                },
                "maxCheckbox":{
                    "regex":"none",
                    "alertText":"* Máximo ",
                    "alertText2":" options allowed"
                },
                "minCheckbox":{
                    "regex":"none",
                    "alertText":"* Please select ",
                    "alertText2":" options"
                },
                "equals":{
                    "regex":"none",
                    "alertText":"* Confirmação incorreta"
                },
                "phone":{
                    // credit: jquery.h5validate.js / orefalo
                    "regex":/^([\+][0-9]{1,3}[ \.\-])?([\(]{1}[0-9]{2,6}[\)])?([0-9 \.\-\/]{3,20})((x|ext|extension)[ ]?[0-9]{1,4})?$/,
                    "alertText":"* Inválido phone number"
                },
                "email":{
                    // Shamelessly lifted from Scott Gonzalez via the Bassistance Validation plugin http://projects.scottsplayground.com/email_address_validation/
                    "regex":/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,
                    "alertText":"* Email inválido"
                },
                "integer":{
                    "regex":/^[\-\+]?\d+$/,
                    "alertText":"* Apenas números"
                },
                "number":{
                    // Number, including positive, negative, and floating decimal. credit: orefalo
                    "regex":/^[\-\+]?(([0-9]+)([\.,]([0-9]+))?|([\.,]([0-9]+))?)$/,
                    "alertText":"* Inválido floating decimal number"
                },
                "date":{
                    "regex":/^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/,
                    "alertText":"* Inválido date, must be in YYYY-MM-DD format"
                },
                "ipv4":{
                    "regex":/^((([01]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))[.]){3}(([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))$/,
                    "alertText":"* Inválido IP address"
                },
                "url":{
                    "regex":/^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i,
                    "alertText":"* Inválido URL"
                },
                "onlyNumberSp":{
                    "regex":/^[0-9\ ]+$/,
                    "alertText":"* Numbers only"
                },
                "onlyLetterSp":{
                    "regex":/^[a-zA-Z\ \']+$/,
                    "alertText":"* Letters only"
                },
                "onlyLetterNumber":{
                    "regex":/^[0-9a-zA-Z]+$/,
                    "alertText":"* No special characters allowed"
                },
                // --- CUSTOM RULES -- Those are specific to the demos, they can be removed or changed to your likings
                "ajaxUserCall":{
                    "url":"ajaxValidateFieldUser",
                    // you may want to pass extra data on the ajax call
                    "extraData":"name=eric",
                    "alertText":"* This user is already taken",
                    "alertTextLoad":"* Validating, please wait"
                },
                "ajaxUserCallPhp":{
                    "url":"phpajax/ajaxValidateFieldUser.php",
                    // you may want to pass extra data on the ajax call
                    "extraData":"name=eric",
                    // if you provide an "alertTextOk", it will show as a green prompt when the field validates
                    "alertTextOk":"* This username is available",
                    "alertText":"* This user is already taken",
                    "alertTextLoad":"* Validating, please wait"
                },
                "ajaxNameCall":{
                    // remote json service location
                    "url":"ajaxValidateFieldName",
                    // error
                    "alertText":"* This name is already taken",
                    // if you provide an "alertTextOk", it will show as a green prompt when the field validates
                    "alertTextOk":"* This name is available",
                    // speaks by itself
                    "alertTextLoad":"* Validating, please wait"
                },
                "ajaxNameCallPhp":{
                    // remote json service location
                    "url":"phpajax/ajaxValidateFieldName.php",
                    // error
                    "alertText":"* This name is already taken",
                    // speaks by itself
                    "alertTextLoad":"* Validating, please wait"
                },
                "validate2fields":{
                    "alertText":"* Please input HELLO"
                },
                //tls warning:homegrown not fielded
                "dateFormat":{
                    "regex":/^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$|^(?:(?:(?:0?[13578]|1[02])(\/|-)31)|(?:(?:0?[1,3-9]|1[0-2])(\/|-)(?:29|30)))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^(?:(?:0?[1-9]|1[0-2])(\/|-)(?:0?[1-9]|1\d|2[0-8]))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^(0?2(\/|-)29)(\/|-)(?:(?:0[48]00|[13579][26]00|[2468][048]00)|(?:\d\d)?(?:0[48]|[2468][048]|[13579][26]))$/,
                    "alertText":"* Inválido Date"
                },
                //tls warning:homegrown not fielded 
                "dateTimeFormat":{
                    "regex":/^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])\s+(1[012]|0?[1-9]){1}:(0?[1-5]|[0-6][0-9]){1}:(0?[0-6]|[0-6][0-9]){1}\s+(am|pm|AM|PM){1}$|^(?:(?:(?:0?[13578]|1[02])(\/|-)31)|(?:(?:0?[1,3-9]|1[0-2])(\/|-)(?:29|30)))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^((1[012]|0?[1-9]){1}\/(0?[1-9]|[12][0-9]|3[01]){1}\/\d{2,4}\s+(1[012]|0?[1-9]){1}:(0?[1-5]|[0-6][0-9]){1}:(0?[0-6]|[0-6][0-9]){1}\s+(am|pm|AM|PM){1})$/,
                    "alertText":"* Inválido Date or Date Format",
                    "alertText2":"Expected Format: ",
                    "alertText3":"mm/dd/yyyy hh:mm:ss AM|PM or ",
                    "alertText4":"yyyy-mm-dd hh:mm:ss AM|PM"
                },
                "dateBr":{
                    "alertText":"* Data inválida"
                }
            };

        }
    };
    $.validationEngineLanguage.newLang();
})(jQuery);


function validateDate(field, rules, i, options) {
    var val = field.val().split('/');
    if (!/[1-31]/.test(val[0]) || !/[1-12]/.test(val[1]) || !/([1-2]{1})([0-9]{3})/.test(val[2])) {
        return options.allrules.dateBr.alertText;
    }
}

function validateCpf(field, rules, i, options) {
    var cpf = field.val();
    var exp = /\.|\-/g;
    cpf = cpf.toString().replace(exp, "");
    var digitoDigitado = eval(cpf.charAt(9) + cpf.charAt(10));
    var soma1 = 0, soma2 = 0;
    var vlr = 11;

    for (var i = 0; i < 9; i++) {
        soma1 += eval(cpf.charAt(i) * (vlr - 1));
        soma2 += eval(cpf.charAt(i) * vlr);
        vlr--;
    }
    soma1 = (((soma1 * 10) % 11) == 10 ? 0 : ((soma1 * 10) % 11));
    soma2 = (((soma2 + (2 * soma1)) * 10) % 11);

    var digitoGerado = (soma1 * 10) + soma2;
    if (digitoGerado != digitoDigitado) {
        return options.allrules.dateRange.alertText;
    }
}