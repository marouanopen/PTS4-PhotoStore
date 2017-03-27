/**
 * Created by Arjan on 26-3-2017.
 */
function clickFunction(){
    var eleDiv = document.getElementById('userInfo');

// based on condition you can change visibility
    if(eleDiv.style.display == 'block') {
        eleDiv.style.display = 'none';
    }
    else {
        eleDiv.style.display = 'block';
    }
}