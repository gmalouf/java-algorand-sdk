package com.algorand.algosdk.v2.client.algod;

import com.algorand.algosdk.v2.client.common.Client;
import com.algorand.algosdk.v2.client.common.HttpMethod;
import com.algorand.algosdk.v2.client.common.Query;
import com.algorand.algosdk.v2.client.common.QueryData;
import com.algorand.algosdk.v2.client.common.Response;
import com.algorand.algosdk.v2.client.model.TransactionGroupLedgerStateDeltasForRoundResponse;


/**
 * Get ledger deltas for transaction groups in a given round.
 * /v2/deltas/{round}/txn/group
 */
public class GetTransactionGroupLedgerStateDeltasForRound extends Query {

    private Long round;

    /**
     * @param round A round number.
     */
    public GetTransactionGroupLedgerStateDeltasForRound(Client client, Long round) {
        super(client, new HttpMethod("get"));
        addQuery("format", "msgpack");
        this.round = round;
    }

   /**
    * Execute the query.
    * @return the query response object.
    * @throws Exception
    */
    @Override
    public Response<TransactionGroupLedgerStateDeltasForRoundResponse> execute() throws Exception {
        Response<TransactionGroupLedgerStateDeltasForRoundResponse> resp = baseExecute();
        resp.setValueType(TransactionGroupLedgerStateDeltasForRoundResponse.class);
        return resp;
    }

   /**
    * Execute the query with custom headers, there must be an equal number of keys and values
    * or else an error will be generated.
    * @param headers an array of header keys
    * @param values an array of header values
    * @return the query response object.
    * @throws Exception
    */
    @Override
    public Response<TransactionGroupLedgerStateDeltasForRoundResponse> execute(String[] headers, String[] values) throws Exception {
        Response<TransactionGroupLedgerStateDeltasForRoundResponse> resp = baseExecute(headers, values);
        resp.setValueType(TransactionGroupLedgerStateDeltasForRoundResponse.class);
        return resp;
    }

    protected QueryData getRequestString() {
        if (this.round == null) {
            throw new RuntimeException("round is not set. It is a required parameter.");
        }
        addPathSegment(String.valueOf("v2"));
        addPathSegment(String.valueOf("deltas"));
        addPathSegment(String.valueOf(round));
        addPathSegment(String.valueOf("txn"));
        addPathSegment(String.valueOf("group"));

        return qd;
    }
}
