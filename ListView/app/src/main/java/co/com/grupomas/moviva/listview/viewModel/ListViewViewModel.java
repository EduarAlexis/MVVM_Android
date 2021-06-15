package co.com.grupomas.moviva.listview.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import co.com.grupomas.moviva.listview.model.ListViewUseCase;

public class ListViewViewModel extends ViewModel {

    private MutableLiveData<List<String>> listResult;

    public ListViewViewModel() {
        listResult = new MutableLiveData<>();
    }

    public LiveData<List<String>> getListResult(){
        return listResult;
    }

    public void getNameList() {
        listResult.setValue(ListViewUseCase.getListNames());
    }

    public void searchName(String name) {
        listResult.setValue(ListViewUseCase.searchNameInList(name));
    }
}
