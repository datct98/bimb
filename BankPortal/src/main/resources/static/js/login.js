function loginAction(){
    const uname = document.getElementById("uname").value;
    if(uname == null || uname==='')
        alert("Please input user name!")
    const pas = document.getElementById("pass").value;
    if(pas == null || pas ==='')
        alert("Please input password!")
    const error = document.getElementById("ipError");

    const body = { username: uname, password:pas };
    fetch("/bimb/login",{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(body),
    }).then(response => response.json())
        .then((data) => {
            console.log(data.result);
            if(data.result==="ok"){
                document.cookie = data.data.access_token;
                alert(data.data.access_token)
                window.location.href = 'index';
                alert(data.result+" ")
            } else {
                error.style.display ="block";
            }
        }).catch(error => {
        console.log(error);
        alert(error)
    })
}