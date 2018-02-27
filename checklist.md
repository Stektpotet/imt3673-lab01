### The first, entry activity (A1), should have
- [x] editable text field (T1)
- [x] slider (S1)
- [x] a drop-down list of options (L1)
- [x] a button (B1)
### The second activity (A2) should have:
- [x] non-editable text field (T2)
- [x] another non-editable text field (T3)
- [x] a button (B2)
### The third activity (A3) should have:
- [x] a single editable text field (T4)
- [x] a single button (B3)

---

- [x] When user presses B1, activity A2 becomes active.
- [x] When user presses B2, activity A3 becomes active.
- [x] When user presses B3, activity A2 becomes active again.
- [x] When user presses Back button from A2, she will go to A1.
- [x] When user presses Back button from A1, it will quit the app.
- [x] When user presses Back button from A3, it goes back to A2.
- [x] The field T2 shows "Hello " + the value of T1 from A1
- [x] The field T3 shows "From A3: " + the value of T4 from A3
- [x] The selection of the drop-down list L1 from A1 should be persistent between different runs of the application, such that, when the user changes the selection, upon the consecutive execution of the app, the selection is as the user picked it, not as the app had it initially as default when the app was executed for the first time.