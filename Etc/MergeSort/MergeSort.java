import java.util.Arrays;

public class MergeSort { 
	public int[] mergeSort(int[] arr) {
		int len = arr.length;
		int[] aArr = Arrays.copyOfRange(arr, 0, len / 2);
		int[] bArr = Arrays.copyOfRange(arr, len / 2, len);
		int aLen = aArr.length, bLen = bArr.length;
		if(aLen > 1) {
			aArr = mergeSort(aArr);
		}
		if(bLen > 1) {
			bArr = mergeSort(bArr);
		}

		int[] result = new int[aLen + bLen];
		int i = 0, j = 0, c = 0;

		while(true) {
			if(result.length <= c) {
				break;
			} else if(aLen <= i) {
				for(;j < bLen; j++) {
					result[c++] = bArr[j];
				}
				break;
			} else if(bLen <= j) {
				for(;i < aLen; i++) {
					result[c++] = aArr[i];
				}
				break;
			}

			if(aArr[i] == bArr[j]) {
				result[c++] = aArr[i++];
				result[c++] = bArr[j++];
			} else if (aArr[i] > bArr[j]) {
				result[c++] = bArr[j++];
			} else {
				result[c++] = aArr[i++];
			}
		}
		return result;
	}
}
