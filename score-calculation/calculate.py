from skimage.metrics import structural_similarity as ssim
import cv2
from vercel_storage import blob
import os

file = './app/build/outputs/roborazzi/com.github.nidroid.uiperfectcopycontesttest.ExampleUnitTest.yourAnswerTest.png'
actor = os.getenv('GITHUB_ACTOR')
run_number = os.getenv('GITHUB_RUN_NUMBER')

with open(file, 'rb') as fp:
    blob.put(
        pathname='api/v1/blob/' + actor + '/' + run_number + '.png',
        body=fp.read()
    )

expect = cv2.imread('./question/img/except.png')
answer = cv2.imread(file)

msssim_value = ssim(expect, answer, channel_axis=2)

print(msssim_value * 100)
