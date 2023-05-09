import pyautogui as pa
import win32api
import time
import yaml

with open('C:\\Users\\Nahida\\Desktop\\git\\autologin\\user.yaml', 'r', encoding='utf-8') as f:
    result = yaml.load(f.read(), Loader=yaml.FullLoader)


icon_bottom = result['bottomIconPath']

x, y = pa.locateCenterOnScreen(icon_bottom)

print(x, y)
