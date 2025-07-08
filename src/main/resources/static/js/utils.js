// utils.js v1.3

function getData(url, success, params, token) {
    exchangeData(url, 'GET', success, params, token)
}

function exchangeData(url, requestType, success, params, token) {
    let headers = withTokenHeader({
        'Accept': 'application/json'
    }, token);
    fetch(
        url + '?' + (new URLSearchParams(params)).toString(),
        {
            method: requestType,
            headers: headers
        }
    )
        .then(response => response.json())
        .then(data => success(data));
}

function postData(url, body, success, token) {
    exchangeDataWithBody(url, 'POST', body, success, token);
}

function putData(url, body, success, token) {
    exchangeDataWithBody(url, 'PUT', body, success, token);
}

function deleteData(url, body, success, token) {
    exchangeDataWithBody(url, 'DELETE', body, success, token)
}

function exchangeDataWithBody(url, requestType, body, success, token) {
    let headers = withTokenHeader({
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    }, token);
    fetch(
        url,
        {
            method: requestType,
            headers: headers,
            body: JSON.stringify(body)
        }
    )
        .then(response => response.json())
        .then(data => success(data));
}

function withTokenHeader(headers, token) {
    if (token !== undefined) {
        headers['Authorization'] = 'Bearer ' + token;
    }
    return headers;
}

function getValue(selector) {
    return document.querySelector(selector).value;
}

function isChecked(selector) {
    return document.querySelector(selector).checked
}

function setChecked(selector, flag) {
    return document.querySelector(selector).checked = flag;
}

function setValue(selector, value) {
    document.querySelector(selector).value = value;
}

function clearValue(selector) {
    document.querySelector(selector).value = '';
}

function clearChildren(parentSelector) {
    document.querySelector(parentSelector).innerHTML = '';
}

function createElementWithText(tag, text) {
    let element = document.createElement(tag);
    element.textContent = text;
    return element;
}

function createElementWithTextAndClass(tag, text, className) {
    let element = document.createElement(tag);
    element.textContent = text;
    element.className = className;
    return element;
}

function addChild(parentSelector, child) {
    document.querySelector(parentSelector).appendChild(child);
}

function hide(selector) {
    document.querySelector(selector).style.display='none';
}

function show(selector) {
    document.querySelector(selector).style.display='block';
}

function getText(selector) {
    return document.querySelector(selector).textContent;
}

function setText(selector, text) {
    document.querySelector(selector).textContent = text;
}

function setClass(selector, className) {
    document.querySelector(selector).className = className;
}

function setHref(selector, href) {
    document.querySelector(selector).setAttribute('href', href);
}

function copyToClipboard(selector) {
    let element = document.querySelector(selector);
    element.select();
    element.setSelectionRange(0, 99999);
    navigator.clipboard.writeText(element.value);
}
