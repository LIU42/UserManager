function jumpToLoginPage()
{
    window.location.href = "login.jsp";
}

function registerResponseHandler(requestObject)
{
    let submitButton = $("#submit-button");
    let errorInfoWrapper = $("#error-info-wrapper");

    if (requestObject.readyState !== 4 || requestObject.status !== 200)
    {
        errorInfoWrapper.html("注册请求失败！");
        submitButton.html("注册");
        return;
    }
    let responseJSON = JSON.parse(requestObject.responseText);
    let statusCode = responseJSON["statusCode"];

    switch (statusCode)
    {
        case 10000: dialogWrapperFadeIn(); break;
        case 10001: errorInfoWrapper.html("用户名格式不合法！"); break;
        case 10002: errorInfoWrapper.html("密码格式不合法！"); break;
        case 10003: errorInfoWrapper.html("该用户已经存在！"); break;
        case 10004: errorInfoWrapper.html("服务器内部错误！"); break;
    }
    submitButton.html("注册");
}

function doRegister()
{
    let userNameInput = $("#username-input");
    let passwordInput = $("#password-input");
    let submitButton = $("#submit-button");
    let errorInfoWrapper = $("#error-info-wrapper");

    let request = new XMLHttpRequest();
    let requestURL = "register?";

    requestURL += "username=" + userNameInput.val() + "&";
    requestURL += "password=" + passwordInput.val() + "&";

    submitButton.html("注册中...");
    errorInfoWrapper.html("");

    request.onload = function ()
    {
        registerResponseHandler(request);
    }
    request.onerror = function ()
    {
        errorInfoWrapper.html("未知错误！");
        submitButton.html("注册");
    }
    request.ontimeout = function ()
    {
        errorInfoWrapper.html("请求超时！");
        submitButton.html("注册");
    }
    request.open("GET", requestURL, true);
    request.send();
}