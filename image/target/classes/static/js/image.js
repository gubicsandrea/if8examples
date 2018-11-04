window.addEventListener('load', getImage);

function getImage() {
    let imgNode = document.getElementById('imagePreview');
    let imageId = 1;
    let urlParams = new URLSearchParams(window.location.search);
    if(urlParams.has('id')){
        imageId = urlParams.get('id');
    }
    let base64Flag;
    fetch('/image/' + imageId)
    .then(function(response) {
        base64Flag = 'data:' + response.headers.get('content-type') + ';base64,';
        console.log(base64Flag);
        return response.arrayBuffer();
    })
    .then(function(buffer) {
        let imageStr = arrayBufferToBase64(buffer);
        imgNode.src = base64Flag + imageStr;
    });
}

function arrayBufferToBase64(buffer) {
  var binary = '';
  var bytes = [].slice.call(new Uint8Array(buffer));

  bytes.forEach((b) => binary += String.fromCharCode(b));

  return window.btoa(binary);
};