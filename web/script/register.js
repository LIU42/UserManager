function jumpToLoginPage()
{
    window.location.href = "login.jsp";
}

function registerResponseHandler(requestObject)
{
    let submitButton = $("#submit-button");
    let errorInfoDiv = $("#error-info");

    if (requestObject.readyState != 4 || requestObject.status != 200)
    {
        errorInfoDiv.html("注册请求失败！");
        submitButton.html("注册");
        return;
    }
    let responseJSON = JSON.parse(requestObject.responseText);
    let statusCode = responseJSON["statusCode"];

    switch (statusCode)
    {
        case 10000: dialogWrapperFadeIn(); break;
        case 10001: errorInfoDiv.html("用户名格式不合法！"); break;
        case 10002: errorInfoDiv.html("密码格式不合法！"); break;
        case 10003: errorInfoDiv.html("该用户已经存在！"); break;
        case 10004: errorInfoDiv.html("服务器内部错误！"); break;
    }
    submitButton.html("注册");
}

function doRegister()
{
    let userNameInput = $("#username-input");
    let passwordInput = $("#password-input");
    let submitButton = $("#submit-button");
    let errorInfoDiv = $("#error-info");

    let requestObject = new XMLHttpRequest();
    let requestURL = "register?";

    requestURL += "username=" + userNameInput.val() + "&";
    requestURL += "password=" + passwordInput.val() + "&";

    submitButton.html("注册中...");
    errorInfoDiv.html("");

    requestObject.onload = function ()
    {
        registerResponseHandler(requestObject);
    }
    requestObject.onerror = function ()
    {
        errorInfoDiv.html("未知错误！");
        submitButton.html("注册");
    }
    requestObject.ontimeout = function ()
    {
        errorInfoDiv.html("请求超时！");
        submitButton.html("注册");
    }
    requestObject.open("GET", requestURL, true);
    requestObject.send();
}