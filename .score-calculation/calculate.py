from skimage.metrics import structural_similarity as ssim
import cv2

expect = cv2.imread('./question/img/except.png')
answer = cv2.imread('./app/build/outputs/roborazzi/com.github.nidroid.uiperfectcopycontesttest.ExampleUnitTest.yourAnswerTest.png')

msssim_value = ssim(expect, answer, channel_axis=2)

print(msssim_value)
