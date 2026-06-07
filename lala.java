private void uploadVideo() {

    Toast.makeText(getContext(),
            "Uploading...",
            Toast.LENGTH_SHORT).show();

    try {

        File file = uriToFile(videoUri);

        RequestBody requestFile =
                RequestBody.create(file, MediaType.parse("video/*"));

        MultipartBody.Part body =
                MultipartBody.Part.createFormData(
                        "file",
                        file.getName(),
                        requestFile
                );

        RequestBody preset =
                RequestBody.create(
                        "android_video_upload", // YOUR REAL PRESET
                        MultipartBody.FORM
                );

        CloudinaryClient.getService()
                .uploadToCloudinary(body, preset)
                .enqueue(new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(Call<ResponseBody> call,
                                           Response<ResponseBody> response) {

                        try {

                            if (response.body() == null) {

                                Toast.makeText(getContext(),
                                        "Empty response",
                                        Toast.LENGTH_LONG).show();

                                return;
                            }

                            String responseString =
                                    response.body().string();

                            Toast.makeText(getContext(),
                                    "Upload Success",
                                    Toast.LENGTH_SHORT).show();

                            JSONObject obj =
                                    new JSONObject(responseString);

                            String url =
                                    obj.getString("secure_url");

                            saveToBackend(url);

                        } catch (Exception e) {

                            e.printStackTrace();

                            Toast.makeText(getContext(),
                                    e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call,
                                          Throwable t) {

                        t.printStackTrace();

                        Toast.makeText(getContext(),
                                t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });

    } catch (Exception e) {

        e.printStackTrace();

        Toast.makeText(getContext(),
                e.getMessage(),
                Toast.LENGTH_LONG).show();
    }
}