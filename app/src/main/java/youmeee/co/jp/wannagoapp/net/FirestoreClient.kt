package youmeee.co.jp.wannagoapp.net

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

/**
 * Firestore Client
 */
class FirestoreClient {

    private val firestoreClient: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun insertItem(name: String, item: Map<String, Any>, onSuccess: (DocumentReference) -> Unit, onFailure: (Exception) -> Unit) {
        firestoreClient.collection(name)
                .add(item)
                .addOnSuccessListener(onSuccess)
                .addOnFailureListener(onFailure)
    }

    fun getAllPlaces(name: String, onComplete: (Task<QuerySnapshot>) -> Unit) {
        firestoreClient.collection(name)
                .get()
                .addOnCompleteListener(onComplete)
    }
}