from alchemy import Alchemy
from web3 import Web3

# Create a contract instance with web3
contract = web3.eth.contract(abi=abi, bytecode=bytecode)

# Set gas limit and gas price (adjust based on network conditions)
gas_limit = 2100000
gas_price = web3.toWei("20", "gwei")

# Get your wallet address and private key (ensure proper security measures)
wallet_address = "YOUR_WALLET_ADDRESS"
private_key = "YOUR_PRIVATE_KEY"

# Sign the transaction and deploy the contract
tx_hash = contract.constructor().transact({
    "from": wallet_address,
    "gas": gas_limit,
    "gasPrice": gas_price,
    "nonce": web3.eth.get_transaction_count(wallet_address)
}, private_key=private_key)

# Wait for transaction confirmation and get deployed contract address
print(f"Transaction submitted: {tx_hash}")
receipt = web3.eth.wait_for_transaction_receipt(tx_hash)
deployed_address = receipt.contractAddress
print(f"Contract deployed at: {deployed_address}")