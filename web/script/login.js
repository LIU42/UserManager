function jumpToWelcomePage()
{
    window.location.href = "welcome.jsp";
}

function loginResponseHandler(request)
{
    let submitButton = $("#submit-button");
    let errorInfoWrapper = $("#error-info-wrapper");

    if (request.readyState !== 4 || request.status !== 200)
    {
        errorInfoWrapper.html("登录请求失败！");
        submitButton.html("登录");
        return;
    }
    let responseJSON = JSON.parse(request.responseText);
    let statusCode = responseJSON["statusCode"];

    switch (statusCode)
    {
        case 10000: jumpToWelcomePage(); break;
        case 10001: errorInfoWrapper.html("该用户不存在或密码错误！"); break;
        case 10002: errorInfoWrapper.html("服务器内部错误！"); break;
    }
    submitButton.html("登录");
}

function doLogin()
{
    let userNameInput = $("#username-input");
    let passwordInput = $("#password-input");
    let submitButton = $("#submit-button");
    let errorInfoWrapper = $("#error-info-wrapper");

    let request = new XMLHttpRequest();
    let requestURL = "login?";

    requestURL += "username=" + userNameInput.val() + "&";
    requestURL += "password=" + passwordInput.val() + "&";

    submitButton.html("登录中...");
    errorInfoWrapper.html("");

    request.onload = function ()
    {
        loginResponseHandler(request);
    }
    request.onerror = function ()
    {
        errorInfoWrapper.html("未知错误！");
        submitButton.html("登录");
    }
    request.ontimeout = function ()
    {
        errorInfoWrapper.html("请求超时！");
        submitButton.html("登录");
    }
    request.open("GET", requestURL, true);
    request.send();
}