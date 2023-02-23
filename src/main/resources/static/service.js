class Person {
    constructor(id_, fname_, lname_) {
        this.id = id_;
        this.firstName = fname_;
        this.lastName = lname_;
    }
}

function create(e) {
    e.preventDefault();
    const projectName = document.getElementById("projectName").value;
    const input = document.getElementById("input").value;
    const output = document.getElementById("output").value;
    const expected = document.getElementById("expected").value;

    const jsonPerson = {
        "projectName": projectName,
        "input": input,
        "output": output,
        "expected": expected
    }
    const assistantRequest = JSON.stringify(jsonPerson);
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
            alert(JSON.stringify(response));
            document.getElementById("prompt-response").value = response.choices[0].text;
        },
        error: function () {
            alert('Error while request..');
        }
    });

}