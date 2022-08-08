const currentLoc = location.href;
const item = document.getElementsByClassName('menu-link');
const length = item.length;
for (let i = 0; i < length; i++) {
    if(item[i].href === currentLoc) {
        item[i].classList.add("active")
    }
}