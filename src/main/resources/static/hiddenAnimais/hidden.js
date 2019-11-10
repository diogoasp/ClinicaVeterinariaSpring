function hiddenChange() {
  var elem = document.getElementById("hidden_animais");
  if(elem.hidden == false){
    elem.hidden = true;
  } else {
    elem.hidden = false;
  }
}
var action = document.getElementById("animais");

action.addEventListener("click", hiddenChange, false);