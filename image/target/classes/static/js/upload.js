window.addEventListener('load', init);

function init() {
    let uploadButton = document.getElementById('uploadButton');
    uploadButton.addEventListener('click', startUpload);
}

function startUpload() {
    let imageId = document.getElementById('imageId').value;
    let file = document.getElementById('fileToUpload').files[0];
    const formData = new FormData();
    formData.append('file', file);
    let url = '/image';
    if(imageId) {
        url = url + '/' + imageId;
    }
    fetch(url, {
        method: 'POST',
        body: formData
    }).then(response => {
        console.log(response);
        return response.json();
    }).then(message => {
        console.log(message);
        let messageNode = document.getElementById('messageP');
        messageNode.innerText = message;
        document.getElementById('uploadForm').reset();
    });
}