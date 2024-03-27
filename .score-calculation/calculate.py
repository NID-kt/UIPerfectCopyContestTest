from skimage.metrics import structural_similarity as ssim
import cv2

expect = cv2.imread('./question/img/except.png.png')
answer = cv2.imread('./app/build/outputs/roborazzi/com.github.nidroid.uiperfectcopycontesttest.ExampleUnitTest.yourAnswerTest.png')

msssim_value = ssim(expect, answer, multichannel=True)

print(f'MS-SSIM: {msssim_value}')
