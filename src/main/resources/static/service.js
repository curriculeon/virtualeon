function getPrompt(e) {
    e.preventDefault();
    const projectName = document.getElementById("projectName").value;
    const input = document.getElementById("input").value;
    const output = document.getElementById("output").value;
    const expected = document.getElementById("expected").value;

    const request = {
        "projectName": projectName,
        "input": input,
        "output": output,
        "expected": expected
    }
    const assistantRequest = JSON.stringify(request);

    $.ajax({
        type: "POST",
        crossDomain: true,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        url: "/gpt/question",
        data: assistantRequest,
        dataType: "JSON",
        success: function (response) {
            document.getElementById("prompt").innerHTML = response.responseText;
        },
        error: function (err) {
            document.getElementById("prompt").innerHTML = err.responseText;
        }
    });
}

function getResponse(e) {
    e.preventDefault();
    getPrompt(e);
    const projectName = document.getElementById("projectName").value;
    const input = document.getElementById("input").value;
    const output = document.getElementById("output").value;
    const expected = document.getElementById("expected").value;

    const request = {
        "projectName": projectName,
        "input": input,
        "output": output,
        "expected": expected
    }
    const assistantRequest = JSON.stringify(request);
    console.log(assistantRequest)

    $.ajax({
        type: "POST",
        crossDomain: true,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        url: "/gpt/assist",
        data: assistantRequest,
        dataType: "JSON ",
        success: function (response) {
            console.log(response);
            document.getElementById("response").innerHTML = response.choices[0].text;
        },
        error: function () {
            alert('Error while request..');
        }
    });
}