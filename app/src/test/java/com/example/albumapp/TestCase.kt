package com.example.albumapp

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.albumapp.model.ModelAblum
import com.example.albumapp.model.Result
import com.example.albumapp.view.AlbumListFragment
import com.example.albumapp.viewmodel.FragmentListViewmodel
import org.junit.Rule
import org.junit.Before
import org.mockito.MockitoAnnotations
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class TestCase {


    @get:Rule
    var rule = InstantTaskExecutorRule()




    @InjectMocks
    lateinit var viewModel: FragmentListViewmodel

    @Mock
    lateinit var listFragment: AlbumListFragment




    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        viewModel = FragmentListViewmodel()

        listFragment = AlbumListFragment()



    }


    @Test
    @Throws(Exception::class)
    fun readraw() {
        viewModel.getRawdata("{\n" +
                " \"resultCount\":50,\n" +
                " \"results\": [\n" +
                "{\"wrapperType\":\"track\", \"kind\":\"song\", \"artistId\":348580754, \"collectionId\":929825574, \"trackId\":929825615, \"artistName\":\"Meghan Trainor\", \"collectionName\":\"Title (Deluxe Edition)\", \"trackName\":\"All About That Bass\", \"collectionCensoredName\":\"Title (Deluxe Edition)\", \"trackCensoredName\":\"All About That Bass\", \"artistViewUrl\":\"https://music.apple.com/us/artist/meghan-trainor/348580754?uo=4\", \"collectionViewUrl\":\"https://music.apple.com/us/album/all-about-that-bass/929825574?i=929825615&uo=4\", \"trackViewUrl\":\"https://music.apple.com/us/album/all-about-that-bass/929825574?i=929825615&uo=4\", \"previewUrl\":\"https://audio-ssl.itunes.apple.com/itunes-assets/Music1/v4/c5/3c/5d/c53c5d1b-9ec3-95c7-df1f-44a4fe7ed52d/mzaf_8689431380311485251.plus.aac.p.m4a\", \"artworkUrl30\":\"https://is2-ssl.mzstatic.com/image/thumb/Music5/v4/41/7d/a2/417da2f7-b676-4dcb-8f41-8278a2501bf4/source/30x30bb.jpg\", \"artworkUrl60\":\"https://is2-ssl.mzstatic.com/image/thumb/Music5/v4/41/7d/a2/417da2f7-b676-4dcb-8f41-8278a2501bf4/source/60x60bb.jpg\", \"artworkUrl100\":\"https://is2-ssl.mzstatic.com/image/thumb/Music5/v4/41/7d/a2/417da2f7-b676-4dcb-8f41-8278a2501bf4/source/100x100bb.jpg\", \"collectionPrice\":12.99, \"trackPrice\":1.29, \"releaseDate\":\"2014-06-30T07:00:00Z\", \"collectionExplicitness\":\"explicit\", \"trackExplicitness\":\"explicit\", \"discCount\":1, \"discNumber\":1, \"trackCount\":15, \"trackNumber\":2, \"trackTimeMillis\":191489, \"country\":\"USA\", \"currency\":\"USD\", \"primaryGenreName\":\"Pop\", \"contentAdvisoryRating\":\"Explicit\", \"isStreamable\":true}]}")

    }


}