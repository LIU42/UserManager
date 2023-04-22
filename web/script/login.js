function jumpToWelcomePage()
{
    window.location.href = "welcome.jsp";
}

function loginResponseHandler(requestObject)
{
    let submitButton = $("#submit-button");
    let errorInfoDiv = $("#error-info");

    if (requestObject.readyState != 4 || requestObject.status != 200)
    {
        errorInfoDiv.html("登录请求失败！");
        submitButton.html("登录");
        return;
    }
    let responseJSON = JSON.parse(requestObject.responseText);
    let statusCode = responseJSON["statusCode"];

    switch (statusCode)
    {
        case 10000: jumpToWelcomePage(); break;
        case 10001: errorInfoDiv.html("该用户不存在或密码错误！"); break;
        case 10002: errorInfoDiv.html("服务器内部错误！"); break;
    }
    submitButton.html("登录");
}

function doLogin()
{
    let userNameInput = $("#username-input");
    let passwordInput = $("#password-input");
    let submitButton = $("#submit-button");
    let errorInfoDiv = $("#error-info");

    let requestObject = new XMLHttpRequest();
    let requestURL = "login?";

    requestURL += "username=" + userNameInput.val() + "&";
    requestURL += "password=" + passwordInput.val() + "&";

    submitButton.html("登录中...");
    errorInfoDiv.html("");

    requestObject.onload = function ()
    {
        loginResponseHandler(requestObject);
    }
    requestObject.onerror = function ()
    {
        errorInfoDiv.html("未知错误！");
        submitButton.html("登录");
    }
    requestObject.ontimeout = function ()
    {
        errorInfoDiv.html("请求超时！");
        submitButton.html("登录");
    }
    requestObject.open("GET", requestURL, true);
    requestObject.send();
}