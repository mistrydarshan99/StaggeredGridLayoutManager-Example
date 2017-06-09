package com.recyclerview;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.rvList) RecyclerView rvList;
  private ItemAdapter itemAdapter;
  private List<String> listItem = new ArrayList<>();
  public static final @DrawableRes int[] IMAGES = new int[] {
      R.drawable.photo_1, R.drawable.photo_2, R.drawable.photo_3, R.drawable.photo_4,
      R.drawable.photo_5, R.drawable.photo_6, R.drawable.photo_7, R.drawable.photo_8,
      R.drawable.photo_9, R.drawable.photo_10, R.drawable.photo_11, R.drawable.photo_12,
      R.drawable.photo_13, R.drawable.photo_14, R.drawable.photo_15, R.drawable.photo_16,
      R.drawable.photo_17, R.drawable.photo_1, R.drawable.photo_2, R.drawable.photo_3,
      R.drawable.photo_4, R.drawable.photo_5, R.drawable.photo_6, R.drawable.photo_7,
      R.drawable.photo_8, R.drawable.photo_9, R.drawable.photo_10, R.drawable.photo_11,
      R.drawable.photo_12, R.drawable.photo_13, R.drawable.photo_14, R.drawable.photo_15,
      R.drawable.photo_16, R.drawable.photo_17
  };
  public static final String[] GOOGLEIMGARY = new String[] {
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7bSlUhsH9RLod7e65_Xne5MtqiP7ijjn9i8YpkcpoAwnfHZOj3A",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXQOe_rJhq5jiUR6cppdcjuF_wyh6ZNLmYoiMxvD5nfetVdqZW4Q",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7ljrpimtwe9GLgcSuzpAgHT5AEu7ZI461_s7sBG4gOV-B_21KJw",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNZr7Z_Xdq7TMlTbLEIeMux9zUm-IyeDT614zEkr8WM1ZmyNSE",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBrScAR_J7A_O6JRsMs352_en8WQ0JYtGMQFtxGx62kHIDTyujYQ",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTR8oSRnAzZ1HIWSiZbGVsKm44hR6qSOhQoW9pNzqjNNguuatnh",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRR34oixdGRhQ9ITwBBmE7oclzUHHnKgEgC_woFaLesaxCmFtFV",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShaePU_pPzMfxVjXg2KuBQ7kX7vMuS5UQ4QRUByBR9Tl38wd3dZw",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2Vpi0DetdTwGvUv0CeUj5X2NRE87oAHxD8ri0yJD_XQi_xO2N",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShlv3_NMbmNltn7KcehnoXwuvVn2aMu_OP0IAUcmo3wPzT71p5",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStKHst0XpHCiUzJWTFaRF3GjCqDMo9_pSWwCxnCoJam_iyg3iz8Q",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtBcaTJ_J_77jAQS1mF1P7n2uM6xAiUHHIJDTbWsjDc2ThLCH8",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKLqGpmtDdplg4F0_2IDhh-rtdH9ZPWpnewr4dXra6gmWWhq4sOQ",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9crNCdpUybI16_UzJtZP5528-dxXPCAeRL3OVUzv5tvtPN8AnZA",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_Zb8xj1huh54_1vIC0Hnyf0n3-gt_ZrWCU9zpVZGKPcmnhwrt8w",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQF3Bo_zucPuDWHcwmfHHD0SFn4QjgmrGxIoL4iGi3Ba60qhO56jw",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1jCvmJ4cHz_NwDBT5Na9W96Hn6kHeOT6i75GRfPccduQBmpA_nA",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDNCgd32trsLKEF2X_F5_D26tNV7AvYpD8hWIgcIZgB7GOIEsY",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQu_-ixU8IwiOpE59jaJ8S5_Zf9FflUaIYtlHWG99GArrsV-Nxs",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTC-EZyvoEXDipKjmOPiaQFw24Hr0zYhE-oCbxpdGZPfpBlMrYrAA",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTF7IEcSDPc09__y9TV-ICBNDvzx9mv16fKJ23Odb4-bhQL_gGflQ",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCplw19yqNoFxUj2y2tVP8DAXmQk4pSzqeam_ydQ6ZGuQDvVGExA",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTi28Wmd1tmvxkqJikQAL5bJZcpkKzpHM3UWt8St6bqbT1CZ8VS",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrQvXQtdG5qTIO4akrkJUlRaeKNMB0kEn99OH-dNd9Rq9WcI8vMw",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSR1bgeAKLPk5s6HKiwBCTZKwe_BdE43-nuhGGC61VIg_zAupi1",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8nl5s9Oy3meOcmWFAlYSgPgmyTALzwchaoF6fiWYMb1CvfGTz",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-dZYta_yfym2HEbnZrmos_cl0eOSxJtSYUGqZFJs_Av6hJ5LKrg",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcdVo3saIXznU32qm1gMO9ZQ34XzYHc152lrN_cRyllY6X3ye7",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgXJZ0BL4SYeuEj139J0YDSe-o5qiUbl8XDewCTvWVhG5AglS5gg",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSd-pDIGZx-NaS3T73MiVAN8s6VlVqCREk2mn-T-pecCv9lOXue",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSD-0QzLAh8MAK7aP0NUpn-XVTuCvXQ853mN-KDxGQlTYMsUT6onQ",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSw2vPAlp9vkdjGuvP8gzGkoIxGhCxIXngKTY3FzP0vze7-F4mp",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfRl4gEl1MeqhVnhl3R7OeLFNyaiWt9_bRDAXjxnguvF-SXSxHKQ",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEUF2JF7o3DfraVU2uMQmRq9lwgIGSiYDxRSWpb8ZIfWhZ0LBUWg",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOmbEmi_43Ma_WHoBkxam6brEOMUygghBGySyKbOSrNK-vPoIT",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHKRER1wE0T_x3NilWEyBLKSCzdrZPIFRCRC0bsYKb__iC07i6",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-Qje8cMHsIUOJpVB4UNDdFcn4iEs5F64v0kI18t6tcTbRUFRlww",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4zopND4EdSmWxrpfyZ-XcZ-kP0RTXc_vdOWV4BhVlLatAe5nI",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJ8ezUouHTqgfQS6dBn4P02m1RpGGiJOyVRTnPwO13YwJF3508aQ"
  };

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);

    StaggeredGridLayoutManager staggeredGridLayoutManager =
        new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    //staggeredGridLayoutManager.setGapStrategy(
        //StaggeredGridLayoutManager.GAP_HANDLING_NONE);
    //staggeredGridLayoutManager.invalidateSpanAssignments();

    /*GridLayoutManager glm = new GridLayoutManager(this, 3);
    glm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
      @Override public int getSpanSize(int position) {
        if (position % 3 == 2) {
          return 3;
        }
        switch (position % 4) {
          case 1:
          case 3:
            return 1;
          case 0:
          case 2:
            return 2;
          default:
            //never gonna happen
            return -1;
        }
      }
    });*/

    final GridLayoutManager manager = new GridLayoutManager(this, 6);
    manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
      @Override public int getSpanSize(int position) {
        int index = position % 5;
        switch (index) {
          case 0:
            return 2;
          case 1:
            return 2;
          case 2:
            return 2;
          case 3:
            return 3;
          case 4:
            return 3;
        }
        return -1;
      }
    });

    rvList.setLayoutManager(staggeredGridLayoutManager);
    //rvList.setLayoutManager(manager);

    itemAdapter = new ItemAdapter(this);
    for (int i = 0; i < 30; i++) {
      listItem.add("photo_" + i);
    }
    itemAdapter.setListItem(listItem);
    rvList.setAdapter(itemAdapter);
    rvList.setItemAnimator(null);
    rvList.setHasFixedSize(true);
    rvList.setItemViewCacheSize(20);
    rvList.setDrawingCacheEnabled(true);
    rvList.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
  }
}
